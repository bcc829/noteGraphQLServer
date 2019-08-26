package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.note.resource.common.logger.Log
import com.note.resource.model.entity.Member
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.vo.CreatePostCommentInput
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.post.PostRepository
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostCommentResolver: GraphQLResolver<PostComment> {

    @Autowired
    private lateinit var postCommentRepository: PostCommentRepository

    @Autowired
    private lateinit var memberRepository: MemberRepository

    companion object : Log()


    fun getPagenatedPostCommentComments(postComment: PostComment, pageIndex: Int, limit: Int): PagenatedObject<PostComment>{
        logger.info("----------------PostCommentResolver: getPagenatedPostCommentComments()--------------------")
        logger.info("input: pageIndex - $pageIndex,  limit - $limit")

        val pageRequest = PageRequest.of(pageIndex, limit)
        return postCommentRepository.getPostCommentCommentsWithPaging(postComment.seqId!!, pageRequest)
    }

    fun getMember(postComment: PostComment): Member? {
        logger.info("----------------PostCommentResolver: getMember()--------------------")
        return memberRepository.findBySeqIdEquals(postComment.member?.seqId!!)
    }

}