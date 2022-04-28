package com.mayard.coroutinetest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ConfigurationPropertiesScan("com.mayard.coroutinetest.config.property")
@SpringBootApplication
@ComponentScan(basePackages = ["com.mayard.coroutinetest.*"])
class CoroutineTestApplication

fun main(args: Array<String>) {
    runApplication<CoroutineTestApplication>(*args)
}
