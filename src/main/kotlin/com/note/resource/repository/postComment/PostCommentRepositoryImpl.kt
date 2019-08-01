package com.note.resource.repository.postComment

import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.entity.postComment.QPostComment
import com.note.resource.model.vo.PageInfo
import com.note.resource.model.vo.PagenatedObject
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport


class PostCommentRepositoryImpl : PostCommentRepositoryCustom, QuerydslRepositorySupport(PostCommentRepositoryImpl::class.java) {
    override fun getPostCommentWithPaging(postSeqId: Int, pageable: Pageable): PagenatedObject<PostComment> {
        val qPostComment = QPostComment.postComment
        var query = JPAQuery<PostComment>(entityManager)

        query = query.from(qPostComment).where(qPostComment.postSeqId.eq(postSeqId)).orderBy(qPostComment.regDate.asc()).fetchAll()

        val postComments = querydsl?.applyPagination(pageable, query)?.fetch()

        val pagePostComment = PageImpl<PostComment>(postComments!!, pageable, query.fetchCount())

        val totalCount = query.fetchCount()

        return PagenatedObject<PostComment>(
                content = pagePostComment.content,
                pageInfo = PageInfo(
                        totalCount = totalCount,
                        isLast = pagePostComment.isLast,
                        isFirst = pagePostComment.isFirst,
                        hasNext = pagePostComment.hasNext(),
                        numberOfElements = pagePostComment.numberOfElements
                )
        )
    }

    override fun getUserPostCommentWithPaging(regId: String, pageable: Pageable): Page<PostComment> {

        val qPostComment = QPostComment.postComment
        var query = JPAQuery<PostComment>(entityManager)

        query = query.from(qPostComment).where(qPostComment.regId.eq(regId)).orderBy(qPostComment.regDate.asc()).fetchAll()

        val postComments = querydsl?.applyPagination(pageable, query)?.fetch()

        return PageImpl<PostComment>(postComments!!, pageable, query.fetchCount())
    }

}