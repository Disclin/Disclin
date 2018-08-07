package pw.dotdash.disclin.ktor.cache.network

import pw.dotdash.disclin.api.cache.Fetcher
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.guild.Guild
import pw.dotdash.disclin.ktor.request.Requester
import pw.dotdash.disclin.ktor.request.Routes
import pw.dotdash.disclin.ktor.request.get

class GuildNetworkCache(private val requester: Requester) : Fetcher<Snowflake, Guild> {

    override suspend fun get(key: Snowflake): Guild? = requester.get<Guild>(Routes.Guilds.GET(key))

    override suspend fun getValues(): Collection<Guild> = emptySet()
}