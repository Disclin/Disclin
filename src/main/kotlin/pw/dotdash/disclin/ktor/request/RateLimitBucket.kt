package pw.dotdash.disclin.ktor.request

import java.time.Instant

data class RateLimitBucket(var limit: Int, var remaining: Int, var resetAt: Instant)