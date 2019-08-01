package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.model.entity.Member
import com.note.resource.model.entity.SocialMemberInfo
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.socialMemberInfo.SocialMemberInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberQueryResolver : GraphQLQueryResolver {

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


    //findAllPagingPosts(pageIndex: Int, limit: Int): PagenatedPosts!

}