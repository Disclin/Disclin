package pw.dotdash.disclin.ktor.request

import io.ktor.client.response.HttpResponse

val HttpResponse.isSuccessful: Boolean get() = this.status.value in 200..300