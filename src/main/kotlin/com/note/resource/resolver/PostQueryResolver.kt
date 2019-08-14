package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.model.entity.Post
import com.note.resource.model.enum.PostSearchType
import com.note.resource.model.vo.CreatePostInput
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.model.vo.UpdatePostInput
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.post.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostQueryResolver : GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun findAllPagingPosts(pageIndex: Int, limit: Int): PagenatedObject<Post>? {
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postRepository.getPagingPostWithSearch(PostSearchType.ALL, "", pageRequest)
    }


    fun createPost(createPost: CreatePostInput): Post {
        val post = Post(title = createPost.title, content = createPost.content)

        val member = memberRepository.findBySeqIdEquals(createPost.seqId)

        post.member = member

        return postRepository.save(post)
    }

    fun updatePost(updatePost: UpdatePostInput): Post {
        //TODO 글을 작성한 회원이 맞는지 확인하고 틀리면 : unAuthorizedException 발생하게 개발 해야 함
        val post = postRepository.findBySeqId(updatePost.postSeqId)

        updatePost.content?.let { post.content = it }

        updatePost.title?.let { post.title = it }

        return postRepository.save(post)
    }

}