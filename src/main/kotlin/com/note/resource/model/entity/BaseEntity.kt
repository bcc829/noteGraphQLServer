package com.note.resource.model.entity


import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity: Serializable {

    @CreatedDate
    var regDate: Date? = null

    @LastModifiedDate
    var updDate: Date? = null

}