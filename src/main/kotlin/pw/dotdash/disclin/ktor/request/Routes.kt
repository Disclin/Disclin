package pw.dotdash.disclin.ktor.request

import pw.dotdash.disclin.api.entity.Snowflake

@Suppress("FunctionName")
object Routes {

    object Channels {

        fun GET(channel: Snowflake) = "channels/$channel"
        fun MODIFY(channel: Snowflake) = "channels/$channel"
        fun DELETE(channel: Snowflake) = "channels/$channel"

        fun LIST_MESSAGES(channel: Snowflake) = "channels/$channel/messages"
        fun GET_MESSAGE(channel: Snowflake, message: Snowflake) = "channels/$channel/messages/$message"
        fun CREATE_MESSAGE(channel: Snowflake) = "channels/$channel/messages"
        fun EDIT_MESSAGE(channel: Snowflake, message: Snowflake) = "channels/$channel/messages/$message"
        fun DELETE_MESSAGE(channel: Snowflake, message: Snowflake) = "channels/$channel/messages/$message"
        fun DELETE_MESSAGES_BULK(channel: Snowflake) = "channels/$channel/messages/bulk-delete"

        fun CREATE_REACTION(channel: Snowflake, message: Snowflake, emoji: String) = "channels/$channel/messages/$message/reactions/$emoji/@me"
        fun DELETE_REACTION_OWN(channel: Snowflake, message: Snowflake, emoji: String) = "channels/$channel/messages/$message/reactions/$emoji/@me"
        fun DELETE_REACTION_USER(channel: Snowflake, message: Snowflake, emoji: String, user: Snowflake) = "channels/$channel/messages/$message/reactions/$emoji/$user"
        fun LIST_REACTIONS(channel: Snowflake, message: Snowflake, emoji: String) = "channels/$channel/messages/$message/reactions/$emoji"
        fun DELETE_ALL_REACTIONS(channel: Snowflake, message: Snowflake) = "channels/$channel/messages/$message/reactions"

        fun EDIT_PERMISSIONS(channel: Snowflake, overwrite: Snowflake) = "channels/$channel/permissions/$overwrite"
        fun DELETE_PERMISSION(channel: Snowflake, overwrite: Snowflake) = "channels/$channel/permissions/$overwrite"

        fun LIST_INVITES(channel: Snowflake) = "channels/$channel/invites"
        fun CREATE_INVITE(channel: Snowflake) = "channels/$channel/invites"

        fun TRIGGER_TYPING(channel: Snowflake) = "channels/$channel/typing"

        fun LIST_PINNED_MESSAGES(channel: Snowflake) = "channels/$channel/pins"
        fun ADD_PINNED_MESSAGE(channel: Snowflake, message: Snowflake) = "channels/$channel/pins/$message"
        fun REMOVE_PINNED_MESSAGE(channel: Snowflake, message: Snowflake) = "channels/$channel/pins/$message"

        fun CREATE_WEBHOOK(channel: Snowflake) = "channels/$channel/webhooks"
        fun LIST_WEBHOOKS(channel: Snowflake) = "channels/$channel/webhooks"

        fun ADD_DM_RECIPIENT(channel: Snowflake, user: Snowflake) = "channels/$channel/recipients/$user"
        fun REMOVE_DM_RECIPIENT(channel: Snowflake, user: Snowflake) = "channels/$channel/recipients/$user"
    }

    object Gateway {

        fun GET() = "gateway"
        fun GET_BOT() = "gateway/bot"
    }

    object Guilds {

        fun CREATE() = "guilds"
        fun GET(guild: Snowflake) = "guilds/$guild"
        fun MODIFY(guild: Snowflake) = "guilds/$guild"
        fun DELETE(guild: Snowflake) = "guilds/$guild"

        fun LIST_CHANNELS(guild: Snowflake) = "guilds/$guild/channels"
        fun CREATE_CHANNEL(guild: Snowflake) = "guilds/$guild/channels"
        fun MODIFY_CHANNEL_POSITIONS(guild: Snowflake) = "guilds/$guild/channels"

        fun GET_MEMBER(guild: Snowflake, user: Snowflake) = "guilds/$guild/members/$user"
        fun LIST_MEMBERS(guild: Snowflake) = "guilds/$guild/members"
        fun ADD_MEMBER(guild: Snowflake, user: Snowflake) = "guilds/$guild/members/$user"
        fun MODIFY_MEMBER(guild: Snowflake, user: Snowflake) = "guilds/$guild/members/$user"
        fun MODIFY_SELF_NICK(guild: Snowflake) = "guilds/$guild/members/@me/nick"
        fun ADD_MEMBER_ROLE(guild: Snowflake, user: Snowflake, role: Snowflake) = "guilds/$guild/members/$user/roles/$role"
        fun REMOVE_MEMBER_ROLE(guild: Snowflake, user: Snowflake, role: Snowflake) = "guilds/$guild/members/$user/roles/$role"
        fun REMOVE_MEMBER(guild: Snowflake, user: Snowflake) = "guilds/$guild/members/$user"

        fun LIST_BANS(guild: Snowflake) = "guilds/$guild/bans"
        fun CREATE_BAN(guild: Snowflake, user: Snowflake) = "guilds/$guild/bans/$user"
        fun REMOVE_BAN(guild: Snowflake, user: Snowflake) = "guilds/$guild/bans/$user"

        fun LIST_ROLES(guild: Snowflake) = "guilds/$guild/roles"
        fun CREATE_ROLE(guild: Snowflake) = "guilds/$guild/roles"
        fun MODIFY_ROLE_POSITIONS(guild: Snowflake) = "guilds/$guild/roles"
        fun MODIFY_ROLE(guild: Snowflake, role: Snowflake) = "guilds/$guild/roles/$role"
        fun DELETE_ROLE(guild: Snowflake, role: Snowflake) = "guilds/$guild/roles/$role"

        fun GET_PRUNE_COUNT(guild: Snowflake) = "guilds/$guild/prune"
        fun BEGIN_PRUNE(guild: Snowflake) = "guilds/$guild/prune"

        fun LIST_VOICE_REGIONS(guild: Snowflake) = "guilds/$guild/regions"

        fun LIST_INVITES(guild: Snowflake) = "guilds/$guild/invites"

        fun LIST_INTEGRATIONS(guild: Snowflake) = "guilds/$guild/integrations"
        fun CREATE_INTEGRATION(guild: Snowflake) = "guilds/$guild/integrations"
        fun MODIFY_INTEGRATION(guild: Snowflake, integration: Snowflake) = "guilds/$guild/integrations/$integration"
        fun DELETE_INTEGRATION(guild: Snowflake, integration: Snowflake) = "guilds/$guild/integrations/$integration"
        fun SYNC_INTEGRATION(guild: Snowflake, integration: Snowflake) = "guilds/$guild/integrations/$integration/sync"

        fun GET_EMBED(guild: Snowflake) = "guilds/$guild/embed"
        fun MODIFY_EMBED(guild: Snowflake) = "guilds/$guild/embed"

        fun GET_VANITY_URL(guild: Snowflake) = "guilds/$guild/vanity-url"

        fun GET_AUDIT_LOGS(guild: Snowflake) = "guilds/$guild/audit-logs"

        fun LIST_EMOJIS(guild: Snowflake) = "guilds/$guild/emojis"
        fun GET_EMOJI(guild: Snowflake, emoji: Snowflake) = "guilds/$guild/emojis/$emoji"
        fun CREATE_EMOJI(guild: Snowflake) = "guilds/$guild/emojis"
        fun MODIFY_EMOJI(guild: Snowflake, emoji: Snowflake) = "guilds/$guild/emojis/$emoji"
        fun DELETE_EMOJI(guild: Snowflake, emoji: Snowflake) = "guilds/$guild/emojis/$emoji"

        fun LIST_WEBHOOKS(guild: Snowflake) = "guilds/$guild/webhooks"
    }

    object Invites {

        fun GET(code: String) = "invites/$code"
        fun DELETE(code: String) = "invites/$code"
    }

    object Users {

        fun GET_SELF() = "users/@me"
        fun GET(user: Snowflake) = "users/$user"
        fun MODIFY_SELF() = "users/@me"

        fun GET_SELF_GUILDS() = "users/@me/guilds"
        fun LEAVE_SELF_GUILD(guild: Snowflake) = "users/@me/guilds/$guild"

        fun GET_SELF_DMS() = "users/@me/channels"
        fun CREATE_SELF_DM() = "users/@me/channels"

        fun LIST_CONNECTIONS() = "users/@me/connections"
    }

    object Voice {

        fun LIST_REGIONS() = "voice/regions"
    }

    object Webhooks {

        fun GET(webhook: Snowflake) = "webhooks/$webhook"
        fun GET_WTOKEN(webhook: Snowflake, token: String) = "webhooks/$webhook/$token"
        fun MODIFY(webhook: Snowflake) = "webhooks/$webhook"
        fun MODIFY_WTOKEN(webhook: Snowflake, token: String) = "webhooks/$webhook/$token"
        fun DELETE(webhook: Snowflake) = "webhooks/$webhook"
        fun DELETE_WTOKEN(webhook: Snowflake, token: String) = "webhooks/$webhook/$token"

        fun EXECUTE(webhook: Snowflake, token: String) = "webhooks/$webhook/$token"
        fun EXECUTE_SLACK(webhook: Snowflake, token: String) = "webhooks/$webhook/$token/slack"
        fun EXECUTE_GITHUB(webhook: Snowflake, token: String) = "webhooks/$webhook/$token/github"
    }
}