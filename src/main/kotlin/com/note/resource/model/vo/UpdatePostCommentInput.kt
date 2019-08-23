package com.note.resource.model.vo

data class UpdatePostCommentInput(
    val content: String,
    val seqId: Long,
    val memberSeqId: Long
)