package com.note.resource.repository.post

import com.note.resource.model.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Number>, PostRepositoryCustom {
    fun findBySeqId(seqId: Long): Post?
    fun findByTitle(title: String): Post?
}