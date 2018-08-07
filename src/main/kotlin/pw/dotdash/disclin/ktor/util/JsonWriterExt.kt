@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.disclin.ktor.util

import com.google.gson.stream.JsonWriter

class JsonWriterDelegate(val writer: JsonWriter) {

    inline fun jsonObject(block: JsonWriterDelegate.() -> Unit) {
        writer.beginObject()
        this.block()
        writer.endObject()
    }

    inline fun jsonArray(block: JsonWriterDelegate.() -> Unit) {
        writer.beginObject()
        this.block()
        writer.endObject()
    }

    inline infix fun String.on(value: String?) {
        writer.name(this).value(value)
    }

    inline infix fun String.on(value: Boolean?) {
        writer.name(this).value(value)
    }

    inline infix fun String.on(value: Double?) {
        writer.name(this).value(value)
    }

    inline infix fun String.on(value: Long?) {
        writer.name(this).value(value)
    }

    inline infix fun String.on(value: Number?) {
        writer.name(this).value(value)
    }

    inline operator fun String?.unaryPlus() {
        writer.value(this)
    }

    inline operator fun Boolean?.unaryPlus() {
        writer.value(this)
    }

    inline operator fun Double?.unaryPlus() {
        writer.value(this)
    }

    inline operator fun Long?.unaryPlus() {
        writer.value(this)
    }

    inline operator fun Number?.unaryPlus() {
        writer.value(this)
    }

    inline infix fun String.onObject(block: JsonWriterDelegate.() -> Unit) {
        writer.name(this).jsonObject(block)
    }

    inline infix fun String.onArray(block: JsonWriterDelegate.() -> Unit) {
        writer.name(this).jsonArray(block)
    }

    @JvmName("onArrayString")
    inline infix fun String.onArray(values: Collection<String?>) {
        writer.name(this).jsonArray {
            values.forEach { +it }
        }
    }

    @JvmName("onArrayBoolean")
    inline infix fun String.onArray(values: Collection<Boolean?>) {
        writer.name(this).jsonArray {
            values.forEach { +it }
        }
    }

    @JvmName("onArrayDouble")
    inline infix fun String.onArray(values: Collection<Double?>) {
        writer.name(this).jsonArray {
            values.forEach { +it }
        }
    }

    @JvmName("onArrayLong")
    inline infix fun String.onArray(values: Collection<Long?>) {
        writer.name(this).jsonArray {
            values.forEach { +it }
        }
    }

    @JvmName("onArrayNumber")
    inline infix fun String.onArray(values: Collection<Number?>) {
        writer.name(this).jsonArray {
            values.forEach { +it }
        }
    }
}

inline fun JsonWriter.delegate(block: JsonWriterDelegate.() -> Unit): JsonWriter {
    val delegate = JsonWriterDelegate(this)
    delegate.block()
    return this
}

inline fun JsonWriter.jsonObject(block: JsonWriterDelegate.() -> Unit): JsonWriter {
    val delegate = JsonWriterDelegate(this)
    delegate.jsonObject(block)
    return this
}

inline fun JsonWriter.jsonArray(block: JsonWriterDelegate.() -> Unit): JsonWriter {
    val delegate = JsonWriterDelegate(this)
    delegate.jsonArray(block)
    return this
}