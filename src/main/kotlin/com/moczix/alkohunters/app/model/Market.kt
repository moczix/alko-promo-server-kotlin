package com.moczix.alkohunters.app.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "market")
class Market (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = "",
        var userId: Int = 0,
        var googlePlaceId: String = "",
        var address: String = "",
        var latitude: Double = 0.0,
        var longitude: Double = 0.0,


        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        @CreatedDate
        var createdAt: LocalDateTime,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        @LastModifiedDate
        var updatedAt: LocalDateTime
)