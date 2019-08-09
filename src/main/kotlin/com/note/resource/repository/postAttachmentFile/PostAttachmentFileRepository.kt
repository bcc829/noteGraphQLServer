package com.note.resource.repository.postAttachmentFile

import com.note.resource.model.entity.PostAttachmentFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostAttachmentFileRepository: JpaRepository<PostAttachmentFile, Number>{
    fun findBySeqIdAndDeleteFlagIs(seqId: Long, deleteFlag: Boolean = false): PostAttachmentFile
}
