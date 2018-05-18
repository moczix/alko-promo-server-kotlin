package com.moczix.alkohunters.app.config

import com.moczix.alkohunters.app.filter.AuthenticationFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class AuthWebSecurityConfigurerAdapter : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userAuthenticationFilter: AuthenticationFilter

    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {

        http
                .csrf().disable()
                .addFilterAfter(userAuthenticationFilter, BasicAuthenticationFilter::class.java)
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                //.antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/**").authenticated()


                //.anyRequest().authenticated()



    }
}