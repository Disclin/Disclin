package pw.dotdash.disclin.ktor.cache.memory

import pw.dotdash.disclin.api.cache.simple.MapCache
import pw.dotdash.disclin.api.entity.Snowflake
import pw.dotdash.disclin.api.entity.guild.Role

typealias RoleMemoryCache = MapCache<Snowflake, Role>