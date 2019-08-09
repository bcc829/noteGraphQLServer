package com.note.resource.model.entity

import com.querydsl.core.annotations.QueryEntity
import com.note.resource.common.constant.Constant
import org.hibernate.annotations.DynamicInsert
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@QueryEntity
//@DynamicInsert
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post_attachment_file", schema = "test")
data class PostAttachmentFile(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId: Long ?= null,
//        @Column(name="post_seq_id")
//        val postSeqId: Long,
        val rootDirectory: String,
        val subDirectory: String,
        val realFileName: String,
        val extFileName: String,
        var deleteFlag: Boolean? = false,
        @CreatedDate
        var regDate: Date?= null,
        @LastModifiedDate
        var updDate: Date?= null,
//        var delDate: Date?= null,
        val filePath: String,
        val regId: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_seq_id", referencedColumnName = "seq_id")
        val post: Post?

)