@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.disclin.ktor.json

import com.google.gson.JsonArray
import com.google.gson.JsonElement

class JsonArrayBuilder {

    val arr = JsonArray()

    inline operator fun JsonElement.unaryPlus() = arr.add(this)

    inline operator fun Boolean.unaryPlus() = arr.add(this)

    inline operator fun Char.unaryPlus() = arr.add(this)

    inline operator fun Number.unaryPlus() = arr.add(this)

    inline operator fun String.unaryPlus() = arr.add(this)

    inline operator fun Any.unaryPlus() = arr.add(this.toString())
}

inline fun jsonArray(init: JsonArrayBuilder.() -> Unit): JsonArray =
        JsonArrayBuilder().apply(init).arr