package com.note.resource

import com.note.resource.model.entity.Member
import com.note.resource.model.entity.Post
import com.note.resource.model.entity.PostComment
import com.note.resource.model.entity.SocialMemberInfo
import com.note.resource.repository.member.MemberRepository
import com.note.resource.repository.post.PostRepository
import com.note.resource.repository.postComment.PostCommentRepository
import com.note.resource.repository.socialMemberInfo.SocialMemberInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class AppRunner : ApplicationRunner {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var socialMemberInfoRepository: SocialMemberInfoRepository

    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var postCommentRepository: PostCommentRepository

    override fun run(args: ApplicationArguments?) {

        var member = Member(
                nickname = "정2",
                email = "abcd@gmail.com",
                id = "jeong",
                password = "123",
                phoneNumber = "",
                address = ""
        )

        var socialMemberInfo1 = SocialMemberInfo(
                principal = "principal",
                providerType = "FACEBOOK"
        )

//        socialMemberInfo1.member = member

        var socialMemberInfo2 = SocialMemberInfo(
                principal = "principal",
                providerType = "GOOGLE"
        )

//        socialMemberInfo2.member = member

        var post : Post = Post(
                content = "content",
                title = "title"
        )
        post.member = member

        var comment1 = PostComment(
                content = "content1"
        )

        comment1.post = post
        comment1.member = member

        var comment2 = PostComment(
                content = "content2"
        )

        comment2.post = post
        comment2.member = member


        var comment3 = PostComment(
                content = "content3"
        )

        comment3.rootPostComment = comment2
        comment3.member = member


        member.addSocialMemberInfo(socialMemberInfo1)
        member.addSocialMemberInfo(socialMemberInfo2)

        memberRepository.save(member)

//        socialMemberInfoRepository.save(socialMemberInfo1)
//        socialMemberInfoRepository.save(socialMemberInfo2)

        postRepository.save(post)

        postCommentRepository.save(comment1)
        postCommentRepository.save(comment2)
        postCommentRepository.save(comment3)

    }
}