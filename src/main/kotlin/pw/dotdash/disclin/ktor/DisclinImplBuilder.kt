package pw.dotdash.disclin.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.newSingleThreadContext
import pw.dotdash.disclin.api.entity.user.UserStatus

class DisclinImplBuilder(val token: String) {

    /**
     * The [io.ktor.client.engine.HttpClientEngine] that will be used by Disclin's Requester.
     *
     * Default: [CIO]
     */
    var httpEngine: HttpClientEngineFactory<HttpClientEngineConfig> = CIO

    /**
     * The [CoroutineDispatcher] that will be used by Disclin for running event listeners.
     */
    var eventPool: CoroutineDispatcher = newSingleThreadContext("Disclin - Event Pool")

    /**
     * Whether Disclin should use a shutdown hook for clean up on exit.
     *
     * Default: true
     */
    var hasShutdownHook: Boolean = true

    /**
     * The [UserStatus] that our connection will display initially.
     *
     * Default: [UserStatus.ONLINE]
     */
    var status: UserStatus = UserStatus.ONLINE
}