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
@Table(name = "post_comment", schema = "public")
@EntityListeners(AuditingEntityListener::class)
@DynamicInsert
data class PostComment(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId: Int? = null,
        @Column(name="post_seq_id", insertable = false, updatable = false)
        var postSeqId: Int? = null,
        var regId: String,
        @Column(name = "comment_seq_id")
        var commentSeqId: Int? = null,
        @CreatedDate
        val regDate: Date,
        @LastModifiedDate
        var updDate: Date? = null,
//        var delDate: Date? = null,
        var deleteFlag: Boolean? = null,
        var content: String,

        @ManyToOne
//        @JoinColumn(name = "postSeqId")
        var post : Post? = null

//        @OneToMany(targetEntity = PostComment::class, fetch = FetchType.LAZY)
//        @JoinColumn(name = "comment_seq_id")
//        val postCommentList: List<PostComment>
)