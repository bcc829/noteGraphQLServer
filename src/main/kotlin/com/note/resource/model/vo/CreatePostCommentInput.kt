package com.note.resource.model.vo

data class CreatePostCommentInput(
    val content: String,
    val postSeqId: Long,
    val memberSeqId: Long,
    val commentSeqId: Long? = null

)