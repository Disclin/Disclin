package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.api.entity.VoiceState

object VoiceStateAdapter : TypeAdapter<VoiceState>() {

    override fun write(writer: JsonWriter, value: VoiceState) = TODO()

    override fun read(reader: JsonReader): VoiceState = TODO()
}