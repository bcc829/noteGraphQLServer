package com.note.resource.model.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post_attachment_file", schema = "test")
data class PostAttachmentFile(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val seqId: Long? = null,

        val rootDirectory: String,

        val subDirectory: String,

        val realFileName: String,

        val extFileName: String,

        var deleteFlag: Boolean? = false,

        val filePath: String,

        @ManyToOne(fetch = FetchType.LAZY)
        var post: Post? = null

) : BaseEntity()