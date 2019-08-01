package com.note.resource.model.entity

import com.querydsl.core.annotations.QueryEntity
import com.note.resource.common.constant.Constant
import org.hibernate.annotations.DynamicInsert
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@QueryEntity
@DynamicInsert
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post_attachment_file", schema = "public")
data class PostAttachmentFile(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId :Int ?= null,
        @Column(name="post_seq_id")
        val postSeqId: Int,
        val rootDirectory: String,
        val subDirectory: String,
        val realFileName: String,
        val extFileName: String,
        var deleteFlag: Boolean? = false,
        @CreatedDate
        var regDate: Date?,
        @LastModifiedDate
        var updDate: Date?= null,
//        var delDate: Date?= null,
        val filePath: String,
        val regId: String
)