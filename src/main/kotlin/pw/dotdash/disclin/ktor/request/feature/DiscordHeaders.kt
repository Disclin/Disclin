package pw.dotdash.disclin.ktor.request.feature

import io.ktor.client.HttpClient
import io.ktor.client.features.HttpClientFeature
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.http.HttpHeaders
import io.ktor.util.AttributeKey
import pw.dotdash.disclin.api.Constants

class DiscordHeaders(val token: String) {

    class Configuration {

        /**
         * Required: The bot token.
         */
        lateinit var token: String

        fun build(): DiscordHeaders = DiscordHeaders(token)
    }

    companion object Feature : HttpClientFeature<Configuration, DiscordHeaders> {

        override val key: AttributeKey<DiscordHeaders> = AttributeKey("DiscordHeaders")

        override suspend fun prepare(block: Configuration.() -> Unit): DiscordHeaders =
                Configuration().apply(block).build()

        override fun install(feature: DiscordHeaders, scope: HttpClient) {
            scope.requestPipeline.intercept(HttpRequestPipeline.State) {
                if (context.headers[HttpHeaders.Authorization] == null) {
                    context.headers[HttpHeaders.Authorization] = "Bot ${feature.token}"
                }
                if (context.headers[HttpHeaders.UserAgent] == null) {
                    context.headers[HttpHeaders.UserAgent] = "DiscordBot (https://github.com/xDotDash/Disclin, ${Constants.Version})"
                }
            }
        }
    }
}