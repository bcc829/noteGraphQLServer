package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.enum.PostSearchType
import com.note.resource.model.vo.CreatePostInput
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.repository.post.PostRepository
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostQueryResolver(
        val postRepository: PostRepository
) : GraphQLQueryResolver, GraphQLMutationResolver {


    fun findAllPagingPosts(pageIndex: Int, limit: Int): PagenatedObject<Post>? {
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postRepository.getPagingPostWithSearch(PostSearchType.ALL, "", pageRequest)
    }


    fun createPost(createPost: CreatePostInput): Post {
        val post = Post(title = createPost.title, regId = createPost.regId, content = createPost.content)

        return postRepository.save(post)
    }

}