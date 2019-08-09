package com.note.resource.model.enum

enum class NoteErrorCode() {
    VALIDATION_ERROR{
        override fun getMessage(): String {
            return "전달 받은 인자의 형식이 잘못되었습니다."
        }
    },
    COMMENT_INSERT_ERROR{
        override fun getMessage(): String {
            return "답글의 답글은 작성 할 수 없습니다."
        }
    };

    abstract fun getMessage(): String
}