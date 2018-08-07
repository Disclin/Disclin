package pw.dotdash.disclin.ktor.gateway

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.wss
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.experimental.channels.mapNotNull
import pw.dotdash.disclin.api.Constants
import pw.dotdash.disclin.ktor.request.Requester
import pw.dotdash.disclin.ktor.request.Routes
import pw.dotdash.disclin.ktor.request.get

data class GatewayInfo(val url: String, val shards: Int)

class Gateway(val gson: Gson, val client: HttpClient, val requester: Requester) {

    suspend fun connect() {
        val info = requester.get<GatewayInfo>(Routes.Gateway.GET_BOT())!!

        client.wss(host = info.url + "?v=" + Constants.GatewayVersion + "&encoding=json") {
            val hello = (incoming.poll() as? Frame.Text)?.readText()

            for (message in incoming.mapNotNull { it as? Frame.Text }) {
                val text = message.readText()

            }
        }
    }

    suspend fun handleDispatch(type: DispatchType, seq: Int, body: Any? = null) {

    }
}