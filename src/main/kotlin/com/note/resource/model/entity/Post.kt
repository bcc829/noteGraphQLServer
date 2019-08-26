package com.note.resource.model.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post", schema = "test")
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val seqId: Long? = null,

        var title: String,

        var content: String,

        var readCount: Long? = 0,

        var deleteFlag: Boolean? = false,

        @ManyToOne(fetch = FetchType.LAZY)
        var member: Member? = null,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.ALL])
        var postCommentList: MutableList<PostComment> = mutableListOf(),

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.ALL])
        var postAttachmentFileList: MutableList<PostAttachmentFile> = mutableListOf()

) : BaseEntity() {
    fun addPostComment(postComment: PostComment) {
        postComment.post = this
        postCommentList.add(postComment)
    }

    fun addPostAttachment(postAttachmentFile: PostAttachmentFile) {
        postAttachmentFile.post = this
        postAttachmentFileList.add(postAttachmentFile)
    }
}