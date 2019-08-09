package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.model.entity.PostComment
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostCommentQueryResolver: GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private lateinit var postCommentRepository: PostCommentRepository

    fun findPagingPostComments(postSeqId: Long, pageIndex: Int, limit: Int): PagenatedObject<PostComment>?{
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postCommentRepository.getPostCommentWithPaging(postSeqId, pageRequest)
    }
}