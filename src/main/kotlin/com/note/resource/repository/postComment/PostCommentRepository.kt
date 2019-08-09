package com.note.resource.repository.postComment

import com.note.resource.model.entity.PostComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostCommentRepository : JpaRepository<PostComment, Number>, PostCommentRepositoryCustom{
    fun findBySeqId(seqId: Long): PostComment
    fun findAllByCommentSeqId(seqId: Long): List<PostComment>?



    fun findAllByPostSeqId(seaId: Long) : List<PostComment>?
}