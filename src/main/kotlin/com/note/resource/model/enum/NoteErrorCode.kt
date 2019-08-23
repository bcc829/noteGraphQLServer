package com.note.resource.model.enum

enum class NoteErrorCode() {
    VALIDATION_ERROR {
        override fun getMessage(): String {
            return "전달 받은 인자의 형식이 잘못되었습니다."
        }
    },
    COMMENT_INSERT_ERROR {
        override fun getMessage(): String {
            return "답글의 답글은 작성 할 수 없습니다."
        }
    },
    UNAUTHORIZED_USER {
        override fun getMessage(): String {
            return "인증되지 않은 사용자 입니다."
        }
    },
    DATA_NOT_FOUND {
        override fun getMessage(): String {
            return "해당하는 데이터가 존재 하지 않습니다."
        }
    };

    abstract fun getMessage(): String
}