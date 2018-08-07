package pw.dotdash.disclin.ktor.event

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.BroadcastChannel
import kotlinx.coroutines.experimental.channels.mapNotNull
import kotlinx.coroutines.experimental.launch
import pw.dotdash.disclin.api.event.Event
import pw.dotdash.disclin.api.event.EventDispatcher
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

class EventDispatcherImpl(private val ctx: CoroutineContext = CommonPool) : EventDispatcher {

    private val channel = BroadcastChannel<Event>(16)

    override fun <T : Event> post(event: T) {
        launch(ctx) {
            channel.send(event)
        }
    }

    override fun <T : Event> on(type: KClass<T>, handler: suspend (T) -> Unit) {
        launch(ctx) {
            val subscriber = channel.openSubscription().mapNotNull { type.safeCast(it) }
            while (true) {
                handler(subscriber.receive())
            }
        }
    }
}