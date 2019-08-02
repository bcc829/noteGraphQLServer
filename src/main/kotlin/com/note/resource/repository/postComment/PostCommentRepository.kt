package com.note.resource.repository.postComment

import com.note.resource.model.entity.PostComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostCommentRepository : JpaRepository<PostComment, Number>, PostCommentRepositoryCustom{
    fun findBySeqId(seqId: Int): PostComment
    fun findAllByCommentSeqId(seqId: Int): List<PostComment>?

    fun findAllByPostSeqId(seaId: Int) : List<PostComment>?
}