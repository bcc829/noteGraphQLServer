package com.note.resource.domain.member

import com.querydsl.core.annotations.QueryEntity
import com.note.resource.common.constant.Constant
import com.note.resource.domain.socialMemberInfo.SocialMemberInfo
import org.hibernate.annotations.DynamicInsert
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*
import javax.persistence.*

@Entity
//@QueryEntity
@Table(name = "member", schema = "public")
//@DynamicInsert
data class Member(
        val seqId : Int? = null,
        @Id
        val id: String? = null,
        var password: String? = null,
        var phoneNumber: String? = null,
        var address: String? = null,
        var nickname: String? = null,
        var email: String? = null,
        val regDate: Date? = DateTime.now(DateTimeZone.forID(Constant.TIME_ZONE)).toDate()
        )