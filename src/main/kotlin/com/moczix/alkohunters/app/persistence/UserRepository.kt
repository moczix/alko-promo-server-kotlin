package com.moczix.alkohunters.app.persistence


import com.moczix.alkohunters.app.model.User
import org.springframework.data.repository.CrudRepository

interface  UserRepository : CrudRepository<User, Int>