package com.note.resource.repository.postComment

import com.note.resource.domain.postComment.PostComment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface PostCommentRepositoryCustom  {
    fun getPostCommentWithPaging(postSeqId: Int, pageable: Pageable): Page<PostComment>
    fun getUserPostCommentWithPaging(regId: String, pageable: Pageable): Page<PostComment>
}