package pw.dotdash.disclin.ktor.entity.user

import pw.dotdash.disclin.api.builder.MessageBuilder
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.channel.direct.DirectTextChannel
import pw.dotdash.disclin.api.entity.message.Embed
import pw.dotdash.disclin.api.entity.message.Message
import pw.dotdash.disclin.api.entity.user.Activity
import pw.dotdash.disclin.api.entity.user.User

data class UserImpl(override val id: Snowflake,
                    override val name: String,
                    override val discriminator: String,
                    override val avatar: String?,
                    override val bot: Boolean,
                    override val mfaEnabled: Boolean) : User {

    override val activity: Activity? = null

    override suspend fun openChannel(): DirectTextChannel {
        TODO("not implemented")
    }

    override suspend fun sendMessage(content: String): Message {
        TODO("not implemented")
    }

    override suspend fun sendMessage(embed: Embed): Message {
        TODO("not implemented")
    }

    override suspend fun sendMessage(init: suspend MessageBuilder.() -> Unit): Message {
        TODO("not implemented")
    }

    override suspend fun sendTyping() {
        TODO("not implemented")
    }
}