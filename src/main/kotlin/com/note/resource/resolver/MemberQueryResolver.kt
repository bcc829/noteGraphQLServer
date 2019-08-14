package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.model.entity.Member
import com.note.resource.repository.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberQueryResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    fun getMemberBySeqId(seqId: Long): Member? {
        return memberRepository.findBySeqIdEquals(seqId)
    }

//    fun socialMemberInfoByMemberId(memberId: String): List<SocialMemberInfo>? {
//        return socialMemberInfoRepository.findByMemberId(memberId)
////        throw CustomException(NoteErrorCode.VALIDATION_ERROR)
//    }


    //findAllPagingPosts(pageIndex: Int, limit: Int): PagenatedPosts!

}