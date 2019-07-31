package com.note.resource.repository.socialMemberInfo

import com.note.resource.domain.socialMemberInfo.SocialMemberInfo
import org.springframework.data.jpa.repository.JpaRepository


interface SocialMemberInfoRepository: JpaRepository<SocialMemberInfo, Number> {
    fun findByMemberId(memberId: String): List<SocialMemberInfo>?
}