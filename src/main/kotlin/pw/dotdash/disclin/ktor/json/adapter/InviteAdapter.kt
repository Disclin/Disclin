package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.api.entity.guild.Invite

object InviteAdapter : TypeAdapter<Invite>() {

    override fun write(writer: JsonWriter, value: Invite) = TODO()

    override fun read(reader: JsonReader): Invite = TODO()
}