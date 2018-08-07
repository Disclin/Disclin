package pw.dotdash.disclin.ktor

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.ws
import io.ktor.client.request.get
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.channels.mapNotNull
import pw.dotdash.disclin.api.Disclin
import pw.dotdash.disclin.api.builder.GuildBuilder
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.channel.DirectTextChannel
import pw.dotdash.disclin.api.entity.channel.GuildCategory
import pw.dotdash.disclin.api.entity.channel.GuildTextChannel
import pw.dotdash.disclin.api.entity.channel.GuildVoiceChannel
import pw.dotdash.disclin.api.entity.guild.Guild
import pw.dotdash.disclin.api.entity.guild.Invite
import pw.dotdash.disclin.api.entity.guild.Role
import pw.dotdash.disclin.api.entity.message.Emoji
import pw.dotdash.disclin.api.entity.user.SelfUser
import pw.dotdash.disclin.api.entity.user.User
import pw.dotdash.disclin.api.entity.user.UserStatus
import pw.dotdash.disclin.api.entity.webhook.Webhook
import pw.dotdash.disclin.api.event.EventDispatcher
import pw.dotdash.disclin.ktor.cache.memory.GuildMemoryCache
import pw.dotdash.disclin.ktor.cache.memory.UserMemoryCache
import pw.dotdash.disclin.ktor.cache.network.GuildNetworkCache
import pw.dotdash.disclin.ktor.cache.network.UserNetworkCache
import pw.dotdash.disclin.ktor.event.EventDispatcherImpl
import pw.dotdash.disclin.ktor.request.Requester
import pw.dotdash.disclin.ktor.request.feature.DiscordHeaders
import pw.dotdash.disclin.ktor.request.feature.DiscordRateLimits

class DisclinImpl(override val token: String,
                  private val httpEngine: HttpClientEngineFactory<HttpClientEngineConfig>,
                  private val eventPool: CoroutineDispatcher,
                  private val shutdownHook: Boolean,
                  private val initialStatus: UserStatus,
                  override val eventDispatcher: EventDispatcher) : Disclin {

    private val httpClient: HttpClient = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                this.serializeNulls()
            }
        }
        install(WebSockets)
        install(DiscordHeaders) {
            token = this@DisclinImpl.token
        }
        install(DiscordRateLimits)
    }

    private val requester = Requester(httpClient, Gson())

    override val userCache = UserMemoryCache() compose UserNetworkCache(requester)
    override val guildCache = GuildMemoryCache() compose GuildNetworkCache(requester)
    override val categoryCache = TODO("not implemented")
    override val guildTextChannelCache = TODO("not implemented")
    override val guildVoiceChannelCache = TODO("not implemented")
    override val directTextChannelCache = TODO("not implemented")

    override suspend fun connect() {
        httpClient.ws(host = httpClient.get("")) {
            for (msg in incoming.mapNotNull { it as? Frame.Text }) {
                val text = msg.readText()
            }
        }
    }

    override suspend fun disconnect() {
        TODO("not implemented")
    }

    override suspend fun listUsers(): List<User> = userCache.getValues()

    override suspend fun getUser(id: Snowflake): User? = userCache.get(id)

    override suspend fun getSelfUser(): SelfUser {
        TODO("not implemented")
    }

    override suspend fun createGuild(init: GuildBuilder.() -> Unit): Guild {
        TODO("not implemented")
    }

    override suspend fun listGuilds(): List<Guild> = guildCache.getValues()

    override suspend fun listMutualGuilds(vararg users: Array<User>): List<Guild> {
        TODO("not implemented")
    }

    override suspend fun getGuild(id: Snowflake): Guild? = guildCache.get(id)

    override suspend fun listRoles(): List<Role> {
        TODO("not implemented")
    }

    override suspend fun getRole(id: Snowflake): Role? {
        TODO("not implemented")
    }

    override suspend fun listCategories(): List<GuildCategory> {
        TODO("not implemented")
    }

    override suspend fun getCategory(id: Snowflake): GuildCategory? {
        TODO("not implemented")
    }

    override suspend fun listGuildTextChannels(): List<GuildTextChannel> {
        TODO("not implemented")
    }

    override suspend fun getGuildTextChannel(id: Snowflake): GuildTextChannel? {
        TODO("not implemented")
    }

    override suspend fun listGuildVoiceChannels(): List<GuildVoiceChannel> {
        TODO("not implemented")
    }

    override suspend fun getGuildVoiceChannel(id: Snowflake): GuildVoiceChannel? {
        TODO("not implemented")
    }

    override suspend fun listDirectTextChannels(): List<DirectTextChannel> {
        TODO("not implemented")
    }

    override suspend fun getDirectTextChannel(id: Snowflake): DirectTextChannel? {
        TODO("not implemented")
    }

    override suspend fun listEmojis(): List<Emoji> {
        TODO("not implemented")
    }

    override suspend fun getEmoji(id: Snowflake): Emoji? {
        TODO("not implemented")
    }

    override suspend fun getInvite(code: String): Invite {
        TODO("not implemented")
    }

    override suspend fun deleteInvite(code: String) {
        TODO("not implemented")
    }

    override suspend fun getWebhook(id: Snowflake): Webhook {
        TODO("not implemented")
    }

    override suspend fun deleteWebhook(id: Snowflake) {
        TODO("not implemented")
    }
}

suspend operator fun Disclin.Companion.invoke(token: String, init: DisclinImplBuilder.() -> Unit): Disclin {
    val builder = DisclinImplBuilder(token)
    builder.init()

    return DisclinImpl(token, builder.httpEngine, builder.eventPool, builder.hasShutdownHook, builder.status, EventDispatcherImpl(builder.eventPool))
}