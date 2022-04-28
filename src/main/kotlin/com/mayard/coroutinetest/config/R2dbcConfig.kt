package com.mayard.coroutinetest.config

import com.mayard.coroutinetest.config.property.R2dbcProperty
import io.r2dbc.pool.PoolingConnectionFactoryProvider
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableR2dbcRepositories(basePackages = ["com.mayard.coroutinetest.repository"])
@EnableR2dbcAuditing
@EnableTransactionManagement
class R2dbcConfig(
    private val r2dbcProperty: R2dbcProperty
): AbstractR2dbcConfiguration() {

    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager? {
        return R2dbcTransactionManager(connectionFactory)
    }

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, PoolingConnectionFactoryProvider.POOLING_DRIVER)
                .option(ConnectionFactoryOptions.HOST, r2dbcProperty.host)
                .option(ConnectionFactoryOptions.PORT, r2dbcProperty.port)
                .option(ConnectionFactoryOptions.USER, r2dbcProperty.username)
                .option(ConnectionFactoryOptions.PASSWORD, r2dbcProperty.password)
                .option(ConnectionFactoryOptions.DATABASE, r2dbcProperty.db)
                .option(ConnectionFactoryOptions.PROTOCOL, "mariadb")
                .build()
        )
    }


}