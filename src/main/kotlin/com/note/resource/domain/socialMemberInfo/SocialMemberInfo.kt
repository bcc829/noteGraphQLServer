package com.note.resource.domain.socialMemberInfo

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "public", name = "social_member_info")
data class SocialMemberInfo(
        val memberId: String,
        val providerType: String,
        val principal: String,
        @Id
        val seqId: Int
)