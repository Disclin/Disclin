@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.disclin.ktor.gateway

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import pw.dotdash.disclin.ktor.json.jsonObject

data class Payload(
        @SerializedName("op")
        val op: Int,
        @SerializedName("d")
        val d: JsonElement,
        @SerializedName("s")
        val s: Int? = null,
        @SerializedName("t")
        val t: String? = null) {

    companion object
}

inline fun Payload.Companion.identify(token: String): Payload = Payload(
        op = 2,
        d = jsonObject {
            "token" on token
            "properties" on jsonObject {
                "\$os" on System.getProperty("os.name")
                "\$browser" on "Disclin"
                "\$device" on "Disclin"
            }
            "compress" on false
            "large_threshold" on 250
            "presence" on jsonObject {
                "game" on jsonObject {
                    "name" on "with code."
                    "type" on 0
                }
                "status" on "idle"
                "since" on 91879201
                "afk" on false
            }
        }
)