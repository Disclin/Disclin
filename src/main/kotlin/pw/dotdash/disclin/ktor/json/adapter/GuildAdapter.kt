package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.api.entity.guild.Guild

object GuildAdapter : TypeAdapter<Guild>() {

    override fun write(writer: JsonWriter, value: Guild) = TODO()

    override fun read(reader: JsonReader): Guild = TODO()
}