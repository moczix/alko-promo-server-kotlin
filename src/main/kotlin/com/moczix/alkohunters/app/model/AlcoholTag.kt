package com.moczix.alkohunters.app.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "alcohol_tag")
class AlcoholTag (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    var alcohol_id: Int = 0,
    var tag_id: Int = 0,
    @CreatedDate
    var createdAt: LocalDateTime,
    @LastModifiedDate
    var updatedAt: LocalDateTime
)