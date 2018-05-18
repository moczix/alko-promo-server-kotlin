package com.moczix.alkohunters.app.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*




@Entity
@Table(name = "alcohol")
@EntityListeners(AuditingEntityListener::class)
class Alcohol(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = "",
        var description: String = "",
        var barcode: String = "",
        var image: String = "",
        var voltage: Double = 0.0,
        var capacity: Int = 0,
        //var userId: Int = 0,
        var accepted: Boolean = false,
        var ocenPiwoUrl: String = "",

        @ManyToOne
        var user: User,


        @ManyToOne(optional = false)
        var category: Category,

        @ManyToMany()
        @JoinTable(name = "alcohol_tag",
                joinColumns = [(JoinColumn(name = "alcohol_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "tag_id", referencedColumnName = "id"))])
        var tag: List<Tag>,


        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        @CreatedDate
        var createdAt: Date,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        @LastModifiedDate
        var updatedAt: Date
)

