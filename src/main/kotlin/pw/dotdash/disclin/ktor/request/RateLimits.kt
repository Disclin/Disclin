package pw.dotdash.disclin.ktor.request

object RateLimits {

    const val HEADER_GLOBAL = "X-RateLimit-Global"

    const val HEADER_LIMIT = "X-RateLimit-Limit"

    const val HEADER_REMAINING = "X-RateLimit-Remaining"

    const val HEADER_RESET = "X-RateLimit-Reset"
}