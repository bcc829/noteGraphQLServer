package com.note.resource.repository.postComment

import com.note.resource.model.entity.PostComment
import com.note.resource.model.vo.PagenatedObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface PostCommentRepositoryCustom  {
    fun getPostCommentWithPaging(postSeqId: Int, pageable: Pageable): PagenatedObject<PostComment>
    fun getUserPostCommentWithPaging(regId: String, pageable: Pageable): Page<PostComment>
}