package com.note.resource.common.util

import java.util.regex.Pattern.compile

object ValidationUtil {

    private val emailRegex = compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    )

    fun isEmailFormat(email: String): Boolean{
        return emailRegex.matcher(email).matches()
    }
}