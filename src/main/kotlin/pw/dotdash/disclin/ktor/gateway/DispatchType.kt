package pw.dotdash.disclin.ktor.gateway

enum class DispatchType {

    /**
     * Defines the heartbeat interval.
     */
    HELLO,

    /**
     * Contains the initial state information.
     */
    READY,

    /**
     * Response to [OPCode.Resume].
     */
    RESUMED,

    /**
     * Failure response to [OPCode.Identify] or [OPCode.Resume] or invalid active session.
     */
    INVALID_SESSION,

    /**
     * A new channel was created.
     */
    CHANNEL_CREATE,

    /**
     * A channel was updated.
     */
    CHANNEL_UPDATE,

    /**
     * A channel was deleted.
     */
    CHANNEL_DELETE,

    /**
     * A message was pinned or unpinned.
     */
    CHANNEL_PINS_UPDATE,

    /**
     * Lazy-load for unavailable guilds, guild became available, or user joined a new guild.
     */
    GUILD_CREATE,

    /**
     * A guild was updated.
     */
    GUILD_UPDATE,

    /**
     * A guild became unavailable, or user left/was removed from a guild.
     */
    GUILD_DELETE,

    /**
     * A user was banned from a guild.
     */
    GUILD_BAN_ADD,

    /**
     * A user was unbanned from a guild.
     */
    GUILD_BAN_REMOVE,

    /**
     * Guild emojis were updated.
     */
    GUILD_EMOJIS_UPDATE,

    /**
     * A guild integration was updated.
     */
    GUILD_INTEGRATIONS_UPDATE,

    /**
     * A new user joined a guild.
     */
    GUILD_MEMBER_ADD,

    /**
     * A user was removed from a guild.
     */
    GUILD_MEMBER_REMOVE,

    /**
     * A guild member was updated.
     */
    GUILD_MEMBER_UPDATE,

    /**
     * Response to [OPCode.RequestGuildMembers].
     */
    GUILD_MEMBERS_CHUNK,

    /**
     * A guild role was created.
     */
    GUILD_ROLE_CREATE,

    /**
     * A guild role was updated.
     */
    GUILD_ROLE_UPDATE,

    /**
     * A guild role was deleted.
     */
    GUILD_ROLE_DELETE,

    /**
     * A message was created.
     */
    MESSAGE_CREATE,

    /**
     * A message was edited.
     */
    MESSAGE_UPDATE,

    /**
     * A message was deleted.
     */
    MESSAGE_DELETE,

    /**
     * Multiple messages were deleted at once.
     */
    MESSAGE_DELETE_BULK,

    /**
     * A user reacted to a message.
     */
    MESSAGE_REACTION_ADD,

    /**
     * A user removed a reaction from a message.
     */
    MESSAGE_REACTION_REMOVE,

    /**
     * All reactions were explicitly removed from a message.
     */
    MESSAGE_REACTION_REMOVE_ALL,

    /**
     * A user's presence was updated in a guild.
     */
    PRESENCE_UPDATE,

    /**
     * A user started typing in a channel.
     */
    TYPING_START,

    /**
     * Properties about a user changed.
     */
    USER_UPDATE,

    /**
     * Someone joined, left, or moved a voice channel.
     */
    VOICE_STATE_UPDATE,

    /**
     * A guild's voice server was updated.
     */
    VOICE_SERVER_UPDATE,

    /**
     * A guild channel webhook was created, updated, or deleted.
     */
    WEBHOOKS_UPDATE
}