package com.note.resource.repository.member

import com.note.resource.model.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Number> {
    fun findByIdEquals(id: String): Member?
    fun findBySeqIdEquals(seqId: Long): Member?
    fun findByNickname(nickname: String): Member?
}