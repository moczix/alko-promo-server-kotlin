package com.moczix.alkohunters.app.persistence


import com.moczix.alkohunters.app.model.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface  UserRepository : CrudRepository<User, Int> {
    fun existsByGoogleId(googleId: String): Boolean
    fun findByGoogleId(googleId: String): Optional<User>
}