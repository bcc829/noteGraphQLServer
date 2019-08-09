package com.note.resource

import com.note.resource.model.entity.Member
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.post.PostRepository
import com.note.resource.repository.postComment.PostCommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.*

@Component
@Order(1)
class AppRunner : ApplicationRunner {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var postRepository: PostRepository

//    @Autowired
//    lateinit var postCommentRepository: PostCommentRepository

    override fun run(args: ApplicationArguments?) {

        var member = Member(
                nickname = "정2",
                email = "abcd@gmail.com",
                id = "jeong",
                password = "123",
                phoneNumber = "",
                address = ""
        )

        member = memberRepository.save(member)


        var post : Post = Post(
                content = "content",
                title = "title",
                regId = "정2"
        )
        post.member = member

        var comment1 = PostComment(
                content = "content1",
                regDate = Date(),
                regId = "정2"
        )

//        comment1.post = post

        var comment2 = PostComment(
                content = "content2",
                regDate = Date(),
                regId = "정2"
        )

//        comment2.post = post

        var comment3 = PostComment(
                content = "content3",
                regDate = Date(),
                regId = "정2"
        )

//        comment3.post = post

//        var commentList : MutableList<PostComment> = mutableListOf(comment1, comment2, comment3)
//
//        post.postCommentList = commentList

        post.addComment(comment1)
        post.addComment(comment2)
        post.addComment(comment3)
        postRepository.save(post)


//
//        postCommentRepository.save(comment1)
//        postCommentRepository.save(comment2)
//        postCommentRepository.save(comment3)




    }
}