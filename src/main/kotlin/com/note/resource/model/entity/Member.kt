package com.note.resource.model.entity

import javax.persistence.*

@Entity
@Table(name = "member", schema = "test")
data class Member(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val seqId: Long? = null,

        @Column(unique = true)
        val id: String,

        var password: String,

        var phoneNumber: String? = null,

        var address: String? = null,

        @Column(unique = true)
        val nickname: String,

        @Column(unique = true)
        val email: String,

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "member")
        var socialMemberInfoList: MutableList<SocialMemberInfo> = mutableListOf(),

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "member")
        var postList: MutableList<Post> = mutableListOf(),

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "member")
        var postCommentList: MutableList<PostComment> = mutableListOf()
) : BaseEntity() {
    fun addSocialMemberInfo(socialMemberInfo: SocialMemberInfo) {
        socialMemberInfo.member = this
        socialMemberInfoList.add(socialMemberInfo)
    }

    fun addPost(post: Post) {
        post.member = this
        postList.add(post)
    }

    fun addPostComment(postComment: PostComment) {
        postComment.member = this
        postCommentList.add(postComment)
    }
}