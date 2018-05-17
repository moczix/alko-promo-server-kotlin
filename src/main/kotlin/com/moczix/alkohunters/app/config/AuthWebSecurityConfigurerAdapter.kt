package com.moczix.alkohunters.app.config

import com.moczix.alkohunters.app.filter.AuthenticationFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
class AuthWebSecurityConfigurerAdapter : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userAuthenticationFilter: AuthenticationFilter

    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {

        http
                .addFilterAfter(userAuthenticationFilter, BasicAuthenticationFilter::class.java)
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/alcohols/**")

                .authenticated()
                //.anyRequest().authenticated()



    }
}