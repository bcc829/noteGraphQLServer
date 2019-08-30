package com.note.resource.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration


@Configuration
@EnableResourceServer
@Profile(value = ["staging", "production"])
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .cors().configurationSource { CorsConfiguration().applyPermitDefaultValues() }.and()
                .antMatcher("/**").authorizeRequests()
                .antMatchers(
                        "/graphiql/**",
                        "/voyager",
                        "/vendor/**/**",
                        "/**/favicon.ico",
                        "/images/**",
                        "/css/**",
                        "/javascript/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
    }

}

@Configuration
@EnableResourceServer
@Profile(value = ["default", "dev"])
class ResourceServerConfigurationWithAllPermit : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .cors().configurationSource { CorsConfiguration().applyPermitDefaultValues() }.and()
                .antMatcher("/**").authorizeRequests()
                .anyRequest().permitAll()
    }

}