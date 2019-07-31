package com.note.resource.repository.post

import com.note.resource.common.enum.PostSearchType
import com.note.resource.domain.post.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface PostRepositoryCustom  {
    fun getPostByUserIdLimitOneOrderByRegDateDesc(regId: String): Post?
    fun getPagingPostWithSearch(postSearchType: PostSearchType, value: String, pageable: Pageable): Page<Post>
}