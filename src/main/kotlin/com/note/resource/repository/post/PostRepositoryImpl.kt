package com.note.resource.repository.post

import com.note.resource.model.entity.Post
import com.note.resource.model.entity.QPost
import com.note.resource.model.enum.PostSearchType
import com.note.resource.model.vo.PageInfo
import com.note.resource.model.vo.PagenatedObject
import com.querydsl.jpa.JPQLQuery
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport


class PostRepositoryImpl : PostRepositoryCustom, QuerydslRepositorySupport(PostRepositoryImpl::class.java) {

    override fun getPostByUserIdLimitOneOrderByRegDateDesc(regId: String): Post? {
        val qPost = QPost.post
        val query = JPAQuery<Post>(entityManager)

        return query.from(qPost).where(qPost.member.nickname.eq(regId)).limit(1).orderBy(qPost.regDate.desc()).fetchOne()
    }

    override fun getPagingPostWithSearch(postSearchType: PostSearchType, value: String, pageable: Pageable): PagenatedObject<Post> {
        val qPost = QPost.post
        var query:JPQLQuery<Post>

        when(postSearchType){
            PostSearchType.ALL -> {
                query = from(qPost).where(qPost.deleteFlag.eq(false)).orderBy(qPost.regDate.desc()).fetchAll()
            }
            PostSearchType.CONTENT -> {
                query = from(qPost).where(qPost.deleteFlag.eq(false).and(qPost.content.likeIgnoreCase("%$value%"))).orderBy(qPost.regDate.desc()).fetchAll()
            }
            PostSearchType.REG_ID -> {
                query = from(qPost).where(qPost.deleteFlag.eq(false).and(qPost.member.nickname.likeIgnoreCase("%$value%"))).orderBy(qPost.regDate.desc()).fetchAll()
            }
            PostSearchType.TITLE -> {
                query = from(qPost).where(qPost.deleteFlag.eq(false).and(qPost.title.likeIgnoreCase("%$value%"))).orderBy(qPost.regDate.desc()).fetchAll()
            }
            PostSearchType.TITLE_OR_CONTENT -> {
                query = from(qPost).where(qPost.deleteFlag.eq(false).and(qPost.title.likeIgnoreCase("%$value%").or(qPost.content.likeIgnoreCase("%$value%")))).orderBy(qPost.regDate.desc()).fetchAll()
            }
        }

        val posts = querydsl!!.applyPagination(pageable, query).fetch()

        val totalCount =  query.fetchCount()
        val pageImpl =  PageImpl(posts, pageable, totalCount)

        return PagenatedObject<Post>(
                content = pageImpl.content,
                pageInfo = PageInfo(
                        totalCount = totalCount,
                        isLast = pageImpl.isLast,
                        isFirst = pageImpl.isFirst,
                        hasNext = pageImpl.hasNext(),
                        numberOfElements = pageImpl.numberOfElements

                )

        )
//   return PageImpl<Post>(posts!!, pageable, query.fetchCount())
    }

}