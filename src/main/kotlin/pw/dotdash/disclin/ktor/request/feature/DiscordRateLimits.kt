package pw.dotdash.disclin.ktor.request.feature

import io.ktor.client.HttpClient
import io.ktor.client.features.HttpClientFeature
import io.ktor.client.response.HttpReceivePipeline
import io.ktor.pipeline.PipelinePhase
import io.ktor.util.AttributeKey

class DiscordRateLimits {

    class Configuration {

        fun build(): DiscordRateLimits = DiscordRateLimits()
    }

    companion object Feature : HttpClientFeature<Configuration, DiscordRateLimits> {

        val RateLimits = PipelinePhase("RateLimits")

        override val key: AttributeKey<DiscordRateLimits> = AttributeKey("DiscordRateLimits")

        override suspend fun prepare(block: Configuration.() -> Unit): DiscordRateLimits = Configuration().apply(block).build()

        override fun install(feature: DiscordRateLimits, scope: HttpClient) {
            scope.receivePipeline.insertPhaseAfter(HttpReceivePipeline.State, RateLimits)

            scope.receivePipeline.intercept(RateLimits) { resp ->
            }
        }

    }
}