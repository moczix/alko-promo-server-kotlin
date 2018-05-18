package com.moczix.alkohunters.app.controller


import com.moczix.alkohunters.app.persistence.AlcoholRepository
import com.moczix.alkohunters.app.persistence.UserRepository
import com.moczix.alkohunters.app.request.UpdateAlcohol
import com.moczix.alkohunters.app.utils.GoogleProfile
import com.moczix.alkohunters.app.utils.Validator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse




@RestController
@RequestMapping("/auth")
class AuthController(val userRep: UserRepository, val alcoholRepo: AlcoholRepository) {

    @GetMapping("test")
    fun test() {
        val alcohol = alcoholRepo.findById(220)
        Validator().isValid(alcohol.get(), UpdateAlcohol().rules, UpdateAlcohol().messages)
    }


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

    @GetMapping("is-admin-auth")
    fun isAdminAuth(@RequestHeader("token") token: String,  res: HttpServletResponse) {
        val googleProfile =  GoogleProfile()
        if (googleProfile.isValid(token)) {
            val user = userRep.findByGoogleId(googleProfile.getProfile().googleId);
            if (user.isPresent) {
                res.status = if (user.get().status == 666) HttpServletResponse.SC_OK else HttpServletResponse.SC_NOT_FOUND
            }else res.status = HttpServletResponse.SC_NOT_FOUND
        }else
            res.status = HttpServletResponse.SC_UNAUTHORIZED
    }

}