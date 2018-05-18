package com.moczix.alkohunters.app.filter

import com.moczix.alkohunters.app.persistence.UserRepository
import com.moczix.alkohunters.app.utils.GoogleProfile
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletResponse
import javax.servlet.ServletRequest
import org.springframework.web.filter.GenericFilterBean
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import java.util.ArrayList
import org.springframework.security.core.authority.SimpleGrantedAuthority






@Component
class AuthenticationFilter : GenericFilterBean() {

    @Autowired
    lateinit var userRep: UserRepository;

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val token = (request as HttpServletRequest).getHeader("token")
        if (token != null) {
            val googleProfile = GoogleProfile()
            if (googleProfile.isValid(token)) {
                val user = userRep.findByGoogleId(googleProfile.getProfile().googleId)
                val authorities = ArrayList<SimpleGrantedAuthority>()
                authorities.add(SimpleGrantedAuthority(
                        if (user.get().status == 666) "ROLE_ADMIN" else "ROLE_USER"
                ))
                val authentication = UsernamePasswordAuthenticationToken(user, null, authorities)
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
            }
        }

        chain.doFilter(request, response)
    }

}