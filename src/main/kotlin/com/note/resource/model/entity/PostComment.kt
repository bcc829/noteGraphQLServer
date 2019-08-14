package com.note.resource.model.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@Table(name = "post_comment", schema = "test")
@EntityListeners(AuditingEntityListener::class)
data class PostComment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "seq_id")
        val seqId: Long? = null,

        var deleteFlag: Boolean? = null,

        var content: String? = null,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "rootPostComment", cascade = [CascadeType.ALL])
        var commentsList: MutableList<PostComment>? = mutableListOf(),

        @ManyToOne(fetch = FetchType.LAZY)
        var member: Member? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_seq_id")
        var post: Post? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "comment_seqId")
        var rootPostComment: PostComment? = null

): BaseEntity()