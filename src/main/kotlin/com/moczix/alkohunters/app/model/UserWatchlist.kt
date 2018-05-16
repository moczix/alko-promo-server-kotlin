package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user_watchlist")
class UserWatchlist(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var userId: Int = 0,
        var alcoholId: Int = 0,
        @CreatedDate
        var createdAt: LocalDateTime,
        @LastModifiedDate
        var updatedAt: LocalDateTime
)