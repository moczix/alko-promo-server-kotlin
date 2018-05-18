package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.config.AppConfig
import com.moczix.alkohunters.app.persistence.UserRepository
import com.moczix.alkohunters.app.utils.GoogleProfile
import com.moczix.alkohunters.app.utils.ImageParser
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.Color
import java.net.URL
import javax.servlet.http.HttpServletResponse
import java.io.FileOutputStream
import java.nio.channels.Channels
import java.nio.channels.ReadableByteChannel
import java.io.IOException
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File
import org.imgscalr.Scalr




@RestController
@RequestMapping("/auth")
class AuthController(val userRep: UserRepository) {

    @GetMapping("test")
    fun test() {
        val imageUri = "https://ocen-piwo.pl/upload/warka-radler.png"

        ImageParser().saveFileFromUrl(imageUri, "00000")


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