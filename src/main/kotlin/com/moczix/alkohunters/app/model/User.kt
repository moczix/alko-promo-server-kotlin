package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = "",
        var email: String = "",
        var image: String = "",
        var status: Int = 0,
        var googleId: String = "",
        var guestDeviceId: String = "",
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)