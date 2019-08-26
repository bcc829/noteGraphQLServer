package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.common.logger.Log
import com.note.resource.model.entity.Member
import com.note.resource.repository.member.MemberRepository
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberQueryResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    companion object: Log()

    fun getMemberBySeqId(seqId: Long, env: DataFetchingEnvironment): Member? {
        logger.info("----------------MemberQueryResolver: getMemberBySeqId()--------------------")
        logger.info("input: seqId - $seqId")
        return memberRepository.findBySeqIdEquals(seqId)
    }
}