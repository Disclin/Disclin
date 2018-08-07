@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.disclin.ktor.json

import com.google.gson.JsonElement
import com.google.gson.JsonObject

class JsonObjectBuilder {

    val obj = JsonObject()

    inline infix fun String.on(value: JsonElement): Unit = obj.add(this, value)

    inline infix fun String.on(value: String): Unit = obj.addProperty(this, value)

    inline infix fun String.on(value: Number): Unit = obj.addProperty(this, value)

    inline infix fun String.on(value: Boolean): Unit = obj.addProperty(this, value)

    inline infix fun String.on(value: Char): Unit = obj.addProperty(this, value)

    inline infix fun String.on(value: Any): Unit = obj.addProperty(this, value.toString())
}

inline fun jsonObject(init: JsonObjectBuilder.() -> Unit): JsonObject =
        JsonObjectBuilder().apply(init).obj