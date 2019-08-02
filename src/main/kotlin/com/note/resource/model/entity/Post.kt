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
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post", schema = "public")
@DynamicInsert
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val seqId : Int? = null,
        var title : String,
        var content : String,

        @CreatedDate
        var regDate : Date? = null,

        @LastModifiedDate
        var updDate : Date? = null,
//        var delDate : Date? = null,
//        @ManyToOne(targetEntity = Member::class, fetch = FetchType.LAZY)
//        @JoinColumn(name="reg_id", referencedColumnName = "id")
//        @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
//        val member: Member? = null,
        var regId : String,
        var readCount: Int? = 0,
        var deleteFlag : Boolean? = false,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.ALL] )
//        @JoinColumn(name = "post_seq_id")
        val postCommentList: List<PostComment>? = null
)