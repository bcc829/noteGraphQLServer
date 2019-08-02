package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.vo.PagenatedObject
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
    private lateinit var postRepository: PostRepository

//    fun getPostComment(postComment: PostComment): List<PostComment>? {
//        return postCommentRepository.findAllByCommentSeqId(postComment.seqId!!)
//    }

    fun getPagenatedPostCommentComments(postComment: PostComment, pageIndex: Int, limit: Int): PagenatedObject<PostComment>{
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postCommentRepository.getPostCommentCommentsWithPaging(postComment.seqId!!, pageRequest)
    }
}