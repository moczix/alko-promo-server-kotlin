package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "comment")
class Comment (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var alcoholId: Int = 0,
        var priceId: Int = 0,
        var userId: Int = 0,
        var text: String = "",
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)