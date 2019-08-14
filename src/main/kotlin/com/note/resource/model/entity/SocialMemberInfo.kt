package com.note.resource.model.entity

import javax.persistence.*

@Entity
@Table(schema = "test", name = "social_member_info")
data class SocialMemberInfo(

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        val seqId: Long? = null,

        val providerType: String,

        val principal: String,

        @ManyToOne(fetch = FetchType.LAZY)
        var member: Member? = null

): BaseEntity()