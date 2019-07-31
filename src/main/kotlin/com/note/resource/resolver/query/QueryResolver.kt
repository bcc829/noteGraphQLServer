package com.note.resource.resolver.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.domain.member.Member
import com.note.resource.domain.socialMemberInfo.SocialMemberInfo
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.socialMemberInfo.SocialMemberInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QueryResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Autowired
    private lateinit var socialMemberInfoRepository: SocialMemberInfoRepository

    fun memberBySeqId(seqId: Int): Member? {
        return memberRepository.findBySeqIdEquals(seqId)
    }

    fun socialMemberInfoByMemberId(memberId: String): List<SocialMemberInfo>? {
        return socialMemberInfoRepository.findByMemberId(memberId)
    }

}