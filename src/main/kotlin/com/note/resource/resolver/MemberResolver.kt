package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.note.resource.model.entity.Member
import com.note.resource.model.entity.SocialMemberInfo
import com.note.resource.repository.socialMemberInfo.SocialMemberInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberResolver: GraphQLResolver<Member> {

    @Autowired
    private lateinit var socialMemberInfoRepository: SocialMemberInfoRepository

    fun getSocialMemberInfo(member: Member): List<SocialMemberInfo>? {
        return socialMemberInfoRepository.findByMemberId(member.id)
    }

}