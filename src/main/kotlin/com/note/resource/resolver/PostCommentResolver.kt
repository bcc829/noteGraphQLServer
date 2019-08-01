package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.note.resource.model.entity.PostComment
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PostCommentResolver: GraphQLResolver<PostComment> {
    @Autowired
    private lateinit var postCommentRepository: PostCommentRepository

    fun getPostComment(postComment: PostComment): List<PostComment>? {
        return postCommentRepository.findAllByCommentSeqId(postComment.seqId!!)
    }
}