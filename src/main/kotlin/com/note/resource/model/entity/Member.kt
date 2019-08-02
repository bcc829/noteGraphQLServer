package com.note.resource.model.entity

import com.note.resource.common.constant.Constant
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*
import javax.persistence.*

@Entity
//@QueryEntity
@Table(name = "member", schema = "public")
//@DynamicInsert
data class Member(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        val seqId : Int,
        val id: String,
        var password: String,
        var phoneNumber: String?,
        var address: String?,
        var nickname: String,
        var email: String,
        val regDate: Date

        ) {
        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.REFRESH], mappedBy = "member")
        val socialMemberInfoList: List<SocialMemberInfo>? = null
}