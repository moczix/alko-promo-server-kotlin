package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.persistence.UserRepository
import com.moczix.alkohunters.app.utils.GoogleProfile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/auth")
class AuthController(val userRep: UserRepository) {


    @GetMapping("is-user-auth")
    fun isUserAuth(@RequestHeader("token") token: String,  res: HttpServletResponse) {
        val googleProfile =  GoogleProfile()
        if (googleProfile.isValid(token)) {
            res.status = if (userRep.existsByGoogleId(googleProfile.getProfile().googleId))
                HttpServletResponse.SC_OK
            else
                HttpServletResponse.SC_NOT_FOUND
        }else
        res.status = HttpServletResponse.SC_UNAUTHORIZED
    }


}