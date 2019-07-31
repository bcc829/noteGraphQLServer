package com.note.resource.repository.member

import com.note.resource.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Number> {
    fun findByIdEquals(id: String): Member?
    fun findBySeqIdEquals(seqId: Int): Member?
    fun findByIdAndPassword(id:String, password:String): Member?
}