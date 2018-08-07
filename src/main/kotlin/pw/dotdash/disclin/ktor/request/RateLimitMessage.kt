package pw.dotdash.disclin.ktor.request

import com.google.gson.annotations.SerializedName

data class RateLimitMessage(
        @SerializedName("message")
        val message: String,
        @SerializedName("retry_after")
        val retryAfter: Long,
        @SerializedName("global")
        val global: Boolean
)