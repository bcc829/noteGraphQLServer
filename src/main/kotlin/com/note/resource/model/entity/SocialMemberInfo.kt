package com.note.resource.model.entity

import javax.persistence.*

@Entity
@Table(schema = "test", name = "social_member_info")
data class SocialMemberInfo(
        @Column(name = "member_id", insertable = false, updatable = false)
        val memberId: String,
        val providerType: String,
        val principal: String,
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        val seqId: Long,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id", referencedColumnName = "id")
        val member: Member
)