package com.moczix.alkohunters.app.utils

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.springframework.beans.factory.annotation.Value
import java.util.*
import java.util.Collections.singletonList
import java.util.Collections.singletonList
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.http.javanet.NetHttpTransport
import com.moczix.alkohunters.app.config.AppConfig
import org.springframework.context.annotation.PropertySource

class GoogleProfile {

    private var payload: Payload? = null

    data class Profile(val googleId: String,  val email: String, val image: String, val exist: Boolean )

    fun getProfile(): Profile  {
        if(payload != null) return parseProfile(payload!!) else emptyProfile()
    }

    fun isValid(token: String): Boolean {
        val verifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), JacksonFactory())
                .setAudience(Arrays.asList(AppConfig.googleClientId, AppConfig.googleClientIdWeb))
                .build()
        val idToken = verifier.verify(token)
        if (idToken != null) {
            payload = idToken.payload
            return true
        }
        return false
    }

    private fun parseProfile(data: Payload): Profile {
        return Profile(data.subject, data.email, data["picture"] as String, true )
    }

    private fun emptyProfile(): Nothing {
        throw IllegalArgumentException()
    }

}