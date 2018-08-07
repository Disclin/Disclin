package pw.dotdash.disclin.ktor.gateway

import pw.dotdash.disclin.ktor.gateway.OPCode.Direction.*

enum class OPCode(val code: Int, val direction: Direction) {

    Dispatch(0, RECEIVE),

    Heartbeat(1, BIDIRECTIONAL),

    Identify(2, SEND),

    StatusUpdate(3, SEND),

    VoiceStateUpdate(4, SEND),

    VoiceServerPing(5, SEND),

    Resume(6, SEND),

    Reconnect(7, RECEIVE),

    RequestGuildMembers(8, SEND),

    InvalidSession(9, RECEIVE),

    Hello(10, RECEIVE),

    HeartbeatAck(11, RECEIVE);

    enum class Direction {

        SEND,
        RECEIVE,
        BIDIRECTIONAL
    }
}