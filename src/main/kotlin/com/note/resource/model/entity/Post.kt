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
@EntityListeners(AuditingEntityListener::class)
@Table(name = "post", schema = "test")
//@DynamicInsert
data class Post(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId : Long? = null,

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
        @Column(name = "reg_id", insertable = false, updatable = false)
        var regId : String,
        var readCount: Long? = 0,
        var deleteFlag : Boolean? = false,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "reg_id", referencedColumnName = "nickname")
        var member: Member? = null,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.ALL])
        var postCommentList: MutableList<PostComment> = mutableListOf(),

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = [CascadeType.ALL])
        var postAttachmentFileList: MutableList<PostAttachmentFile> = mutableListOf()
) {
        fun addComment(postComment: PostComment) {
                this.postCommentList.add(postComment)
                postComment.post = this
        }
}