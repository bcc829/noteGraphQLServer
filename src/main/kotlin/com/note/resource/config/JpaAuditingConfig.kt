package com.note.resource.config

import com.note.resource.common.constant.Constant
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "utcDateTimeProvider")
class JpaAuditingConfig {
    @Bean
    fun utcDateTimeProvider(): DateTimeProvider {
        return DateTimeProvider { Optional.of(LocalDateTime.now(ZoneId.of(Constant.TIME_ZONE))) }
    }
}
