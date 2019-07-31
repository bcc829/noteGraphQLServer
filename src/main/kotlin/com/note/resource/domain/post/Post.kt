package com.note.resource.domain.post

import com.querydsl.core.annotations.QueryEntity
import com.note.resource.common.constant.Constant
import com.note.resource.domain.postComment.PostComment
import org.hibernate.annotations.DynamicInsert
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*
import javax.persistence.*

@Entity
@QueryEntity
@Table(name = "post", schema = "public")
@DynamicInsert
data class Post(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        val seqId : Int? = null,
        var title : String,
        var content : String,
        var regDate : Date? = DateTime.now(DateTimeZone.forID(Constant.TIME_ZONE)).toDate(),
        var updDate : Date? = null,
        var delDate : Date? = null,
//        @ManyToOne(targetEntity = Member::class, fetch = FetchType.LAZY)
//        @JoinColumn(name="reg_id", referencedColumnName = "id")
//        @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
//        val member: Member? = null,
        var regId : String?,
        var readCount: Int? = null,
        var deleteFlag : Boolean? = null
//        @OneToMany(targetEntity = PostComment::class, fetch = FetchType.EAGER)
//        @JoinColumn(name = "post_seq_id")
//        val postCommentList: List<PostComment>? = null
)