package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "alcohol")
class Alcohol(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = "",
        var description: String = "",
        var barcode: String = "",
        var image: String = "",
        var voltage: Double = 0.0,
        var capacity: Int = 0,
        var categoryId: Int = 0,
        var userId: Int = 0,
        var accepted: Int = 0,
        var ocenPiwoUrl: String = "",
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)