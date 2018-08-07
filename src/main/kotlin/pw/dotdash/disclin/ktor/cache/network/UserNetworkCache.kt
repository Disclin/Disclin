package pw.dotdash.disclin.ktor.cache.network

import pw.dotdash.disclin.api.cache.Fetcher
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.user.User
import pw.dotdash.disclin.ktor.request.Requester
import pw.dotdash.disclin.ktor.request.Routes
import pw.dotdash.disclin.ktor.request.get

class UserNetworkCache(private val requester: Requester) : Fetcher<Snowflake, User> {

    override suspend fun get(key: Snowflake): User? = requester.get<User>(Routes.Users.GET(key))

    override suspend fun getValues(): Collection<User> = emptySet()
}