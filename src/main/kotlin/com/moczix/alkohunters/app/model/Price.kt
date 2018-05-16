package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "price")
class Price (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var marketId: Int = 0,
        var alcoholId: Int = 0,
        var userId: Int = 0,
        var price: Double = 0.0,
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)