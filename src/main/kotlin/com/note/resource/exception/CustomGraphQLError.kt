package com.note.resource.exception

import com.fasterxml.jackson.annotation.JsonIgnore
import graphql.ErrorClassification
import graphql.ErrorType
import graphql.GraphQLError
import graphql.language.SourceLocation

class CustomGraphQLError(private val message: String,
                         private val errorType: ErrorClassification,
                         private val location: MutableList<SourceLocation>,
                         private val extension: MutableMap<String, Any>,
                         private val path: MutableList<Any>
) : GraphQLError{

    @JsonIgnore
    override fun getMessage(): String {
        return message
    }

    override fun getErrorType(): ErrorClassification? {
        return errorType
    }

    override fun getLocations(): MutableList<SourceLocation>? {
        return location
    }

    override fun getExtensions(): MutableMap<String, Any> {
        return extension
    }

    override fun getPath(): MutableList<Any> {
        return path
    }

}