package pw.dotdash.disclin.ktor.json.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import pw.dotdash.disclin.api.entity.webhook.Webhook

object WebhookAdapter : TypeAdapter<Webhook>() {

    override fun write(writer: JsonWriter, value: Webhook) = TODO()

    override fun read(reader: JsonReader): Webhook = TODO()
}