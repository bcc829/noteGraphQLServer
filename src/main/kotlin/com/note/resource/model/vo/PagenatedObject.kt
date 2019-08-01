package com.note.resource.model.vo

data class PagenatedObject<T> (
        val content : List<T>? = null,
        val pageInfo : PageInfo
) {
}

data class PageInfo (
        val totalCount: Long,
        val hasNext: Boolean,
        val isLast: Boolean,
        val isFirst: Boolean,
        val numberOfElements: Int
) {}