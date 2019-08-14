package com.note.resource.repository.socialMemberInfo

import com.note.resource.model.entity.SocialMemberInfo
import org.springframework.data.jpa.repository.JpaRepository


interface SocialMemberInfoRepository: JpaRepository<SocialMemberInfo, Number> {
    fun findByMemberId(memberId: String): List<SocialMemberInfo>?
    fun findByMemberSeqId(seqId: Long): List<SocialMemberInfo>?
}