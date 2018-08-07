package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.ktor.gateway.Payload

object PayloadAdapter : TypeAdapter<Payload>() {

    override fun write(writer: JsonWriter, value: Payload) = TODO()

    override fun read(reader: JsonReader): Payload = TODO()
}