package com.note.resource.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.note.resource.exception.CustomException
import com.note.resource.model.entity.PostComment
import com.note.resource.model.enum.NoteErrorCode
import com.note.resource.model.vo.CreatePostCommentInput
import com.note.resource.model.vo.PagenatedObject
import com.note.resource.model.vo.UpdatePostCommentInput
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.post.PostRepository
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PostCommentQueryResolver : GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private lateinit var postCommentRepository: PostCommentRepository

    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var memberRepository: MemberRepository

    fun findPagingPostComments(postSeqId: Long, pageIndex: Int, limit: Int): PagenatedObject<PostComment>? {
        val pageRequest = PageRequest.of(pageIndex, limit)

        return postCommentRepository.getPostCommentWithPaging(postSeqId, pageRequest)
    }

    fun createPostComment(createPostComment: CreatePostCommentInput): PostComment? {

        val postComment = PostComment(content = createPostComment.content)

        val member = memberRepository.findBySeqIdEquals(createPostComment.memberSeqId)
                ?: throw CustomException(NoteErrorCode.UNAUTHORIZED_USER)

        postComment.member = member

        return when (createPostComment.commentSeqId) {
            null -> {
                val post = postRepository.findBySeqId(createPostComment.postSeqId)
                postComment.post = post
                postCommentRepository.save(postComment)
            }

            else -> {
                val rootPostComment = postCommentRepository.findBySeqId(createPostComment.commentSeqId)
                postComment.rootPostComment = rootPostComment
                postCommentRepository.save(postComment)
            }
        }
    }

    fun updatePostComment(updatePostComment: UpdatePostCommentInput): PostComment? {
        val postComment = postCommentRepository.findById(updatePostComment.seqId).get()

        return when (postComment.member?.seqId == updatePostComment.memberSeqId) {
            true -> {
                postComment.content = updatePostComment.content
                postCommentRepository.save(postComment)
            }
            false -> {
                throw CustomException(NoteErrorCode.UNAUTHORIZED_USER)
            }
        }
    }
}