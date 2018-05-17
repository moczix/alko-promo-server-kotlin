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
                val authentication = UsernamePasswordAuthenticationToken(user, null)
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
            }
        }

        chain.doFilter(request, response)
    }

}