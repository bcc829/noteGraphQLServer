package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostResolver: GraphQLResolver<Post> {

    @Autowired
    private lateinit var postCommentRepository: PostCommentRepository

    fun getPagenatedPostComments(post: Post, pageIndex: Int, limit: Int): PagenatedObject<PostComment> {
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postCommentRepository.getPostCommentWithPaging(post.seqId!!, pageRequest)
    }

//    fun getComments(post: Post) : List<PostComment>? {
//        return this.postCommentRepository.findAllByPostSeqId(post.seqId!!)
//
//    }
}