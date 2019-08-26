package com.note.resource.repository.post

import com.note.resource.model.enum.PostSearchType
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.QPost
import com.note.resource.model.vo.PagenatedObject
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.Pageable


interface PostRepositoryCustom  {
    fun getPostByUserIdLimitOneOrderByRegDateDesc(regId: String): Post?
    fun getPagingPostWithSearch(postSearchType: PostSearchType, value: String? = "", pageable: Pageable): PagenatedObject<Post>
}