package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "raport")
class Raport (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var userId: Int = 0,
        var priceId: Int = 0,
        var message: String = "",
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)