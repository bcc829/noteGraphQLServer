package com.note.resource.exception

import com.fasterxml.jackson.annotation.JsonIgnore
import com.note.resource.model.enum.NoteErrorCode
import graphql.ErrorClassification
import graphql.ErrorType
import graphql.language.SourceLocation


class CustomException(private val noteErrorCode: NoteErrorCode): GraphQLBaseException() {

    override fun toSpecification(): MutableMap<String, Any> {
        return super.toSpecification()
    }

    override fun getErrorType(): ErrorClassification {
        return ErrorType.ValidationError
    }

    @JsonIgnore
    override fun getLocations(): MutableList<SourceLocation>? {
        return null
    }

    override fun getExtensions(): MutableMap<String, Any> {
        val extensionMap = mutableMapOf<String, Any>()
        extensionMap["code"] = noteErrorCode.name
        extensionMap["message"] = noteErrorCode.getMessage()
        return extensionMap
    }

    override val message: String?
        get() = noteErrorCode.getMessage()

    override fun getStackTrace(): Array<StackTraceElement>? {
        return null
    }
}