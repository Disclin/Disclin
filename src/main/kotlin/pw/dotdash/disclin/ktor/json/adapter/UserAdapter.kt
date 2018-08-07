package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.user.User
import pw.dotdash.disclin.ktor.entity.user.UserImpl

object UserAdapter : TypeAdapter<User>() {

    override fun write(writer: JsonWriter, value: User) = TODO()

    override fun read(reader: JsonReader): User {
        lateinit var id: Snowflake
        lateinit var name: String
        lateinit var discriminator: String
        var avatar: String? = null
        var bot: Boolean = false
        var mfaEnabled: Boolean = false

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextString()
                "username" -> name = reader.nextString()
                "discriminator" -> discriminator = reader.nextString()
                "avatar" -> avatar = reader.nextString()
                "bot" -> bot = reader.nextBoolean()
                "mfa_enabled" -> mfaEnabled = reader.nextBoolean()
            }
        }
        reader.endObject()

        return UserImpl(id, name, discriminator, avatar, bot, mfaEnabled)
    }
}