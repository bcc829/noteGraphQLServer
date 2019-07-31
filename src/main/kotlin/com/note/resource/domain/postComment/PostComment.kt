package com.note.resource.domain.postComment

import com.querydsl.core.annotations.QueryEntity
import com.note.resource.common.constant.Constant
import org.hibernate.annotations.DynamicInsert
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*
import javax.persistence.*

@Entity
@QueryEntity
@Table(name = "post_comment", schema = "public")
@DynamicInsert
data class PostComment(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId: Int? = null,
        @Column(name="post_seq_id")
        var postSeqId: Int? = null,
        var regId: String,
        @Column(name = "comment_seq_id")
        var commentSeqId: Int? = null,
        val regDate: Date? = DateTime.now(DateTimeZone.forID(Constant.TIME_ZONE)).toDate(),
        var updDate: Date? = null,
        var delDate: Date? = null,
        var deleteFlag: Boolean? = null,
        var content: String,
        @OneToMany(targetEntity = PostComment::class, fetch = FetchType.LAZY)
        @JoinColumn(name = "comment_seq_id")
        val postCommentList: List<PostComment>
)