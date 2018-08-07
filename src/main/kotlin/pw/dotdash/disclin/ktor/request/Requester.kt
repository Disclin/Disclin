package pw.dotdash.disclin.ktor.request

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.client.utils.EmptyContent
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import kotlinx.coroutines.experimental.delay
import pw.dotdash.disclin.api.Constants
import pw.dotdash.disclin.api.exception.DiscordException
import pw.dotdash.disclin.api.exception.http.*
import java.time.Instant

class Requester(private val client: HttpClient, val gson: Gson) {

    val defaultBucket = RateLimitBucket(1, 1, Instant.MAX)

    @Throws(DiscordException::class)
    suspend fun <T : Any, R : Any> request(route: String, body: T? = null, convertBody: Class<T>? = null,
                                           contentType: ContentType = ContentType.Application.Json,
                                           method: HttpMethod = HttpMethod.Get, convertResult: Class<R>,
                                           bucket: RateLimitBucket = defaultBucket, attempt: Int = 0): R? {
        if (attempt > 5) {
            throw IllegalStateException("Exceeded retry attempts for route '$route'")
        }

        if (bucket.remaining < 1) {
            delay(bucket.resetAt.toEpochMilli() - Instant.now().toEpochMilli())
        }

        val response = client.request<HttpResponse> {
            this.url(Constants.ApiUrl + route)
            this.method = method
            this.body = body?.let { TextContent(gson.toJson(body, convertBody), contentType) } ?: EmptyContent
        }

        if (!response.isSuccessful) {
            handleFail(response.status.description, response.status.value)
        }

        return gson.fromJson(response.readText(), convertResult)
    }

    private fun handleFail(message: String, status: Int) {
        when (status) {
            400 -> throw BadRequestException()
            401 -> throw UnauthorizedException()
            403 -> throw ForbiddenException()
            404 -> throw NotFoundException()
            429 -> throw RatelimitException()
            in 500..599 -> throw DiscordException(message) // TODO: Own exception class
        }
    }

    private fun calculateWaitTime(resetTimeSecs: Long): Long =
            resetTimeSecs - (System.currentTimeMillis() / 1000) + 1
}

suspend inline fun <reified T : Any, reified R : Any> Requester.request(route: String, body: T? = null,
                                                                        contentType: ContentType = ContentType.Application.Json,
                                                                        method: HttpMethod = HttpMethod.Get,
                                                                        bucket: RateLimitBucket = defaultBucket): R? =
        request(route, body, T::class.java, contentType, method, R::class.java, bucket)

suspend inline fun <reified R : Any> Requester.get(route: String, bucket: RateLimitBucket = defaultBucket): R? =
        request<Any, R>(route, bucket = bucket)

suspend inline fun <reified T : Any, reified R : Any> Requester.post(route: String, body: T? = null,
                                                                     contentType: ContentType = ContentType.Application.Json,
                                                                     bucket: RateLimitBucket = defaultBucket): R? =
        request(route, body = body, contentType = contentType, method = HttpMethod.Post, bucket = bucket)

suspend inline fun <reified T : Any, reified R : Any> Requester.put(route: String, body: T? = null,
                                                                    contentType: ContentType = ContentType.Application.Json,
                                                                    bucket: RateLimitBucket = defaultBucket): R? =
        request(route, body = body, contentType = contentType, method = HttpMethod.Put, bucket = bucket)

suspend inline fun <reified T : Any, reified R : Any> Requester.patch(route: String, body: T? = null,
                                                                      contentType: ContentType = ContentType.Application.Json,
                                                                      bucket: RateLimitBucket = defaultBucket): R? =
        request(route, body = body, contentType = contentType, method = HttpMethod.Patch, bucket = bucket)

suspend inline fun <reified R : Any> Requester.delete(route: String, bucket: RateLimitBucket = defaultBucket): R? =
        request<Any, R>(route, bucket = bucket)