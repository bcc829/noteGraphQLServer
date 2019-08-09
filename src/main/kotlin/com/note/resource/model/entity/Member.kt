package com.note.resource.model.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
//@QueryEntity
@Table(name = "member", schema = "test")
@EntityListeners(AuditingEntityListener::class)
//@DynamicInsert
data class Member(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="seq_id")
        val seqId : Long? = null,
        @Column(unique = true)
        var id: String,
        var password: String,
        var phoneNumber: String?,
        var address: String?,
        @Column(unique = true)
        var nickname: String,
        @Column(unique = true)
        var email: String,
        @CreatedDate
        val regDate: Date?  = null,
        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "member")
        val socialMemberInfoList: List<SocialMemberInfo>? = null,
        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "member")
        var posts: List<Post?>? = null
        )