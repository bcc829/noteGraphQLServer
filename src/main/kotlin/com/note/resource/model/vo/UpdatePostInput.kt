package com.note.resource.model.vo

data class UpdatePostInput(
        val title: String?,
        val content: String?,
        val memberSeqId: Long,
        val postSeqId: Long
)