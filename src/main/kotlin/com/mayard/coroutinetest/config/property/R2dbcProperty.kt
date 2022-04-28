package com.mayard.coroutinetest.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(value = "r2dbc")
class R2dbcProperty(
    val host: String,
    val port: Int,
    val db: String,
    val username: String,
    val password: String
)