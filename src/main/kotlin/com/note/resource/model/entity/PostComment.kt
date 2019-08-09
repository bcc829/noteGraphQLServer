package com.note.resource.model.entity

import com.querydsl.core.annotations.QueryEntity
import org.hibernate.annotations.DynamicInsert
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
//@QueryEntity
@Table(name = "post_comment", schema = "test")
@EntityListeners(AuditingEntityListener::class)
//@DynamicInsert
data class PostComment(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id", insertable = false, updatable = false )
        val seqId: Long? = null,

//        @Column(name="post_seq_id")
//        var postSeqId: Long? = null,

        var regId: String,
        @Column(name = "comment_seq_id", insertable = false, updatable = false)
        var commentSeqId: Long? = null,

        @CreatedDate
        val regDate: Date,

        @LastModifiedDate
        var updDate: Date? = null,
//        var delDate: Date? = null,
        var deleteFlag: Boolean? = null,
        var content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_seq_id", referencedColumnName = "seq_id")
        var post : Post? = null,


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "comment_seq_id", referencedColumnName = "seq_id")
        var rootPostComment: PostComment? = null,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "rootPostComment", cascade = [CascadeType.ALL])
        var CommentComments: List<PostComment>? = null

//        @OneToMany(targetEntity = PostComment::class, fetch = FetchType.LAZY)
//        @JoinColumn(name = "comment_seq_id")
//        val postCommentList: List<PostComment>
)