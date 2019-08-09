package com.note.resource.exceptionHandler

import com.note.resource.exception.CustomGraphQLError
import graphql.GraphQLError
import graphql.servlet.core.GraphQLErrorHandler
import org.springframework.stereotype.Component

@Component
class CustomGraphQLExceptionHandler: GraphQLErrorHandler {
    override fun processErrors(errors: MutableList<GraphQLError>): MutableList<GraphQLError> {

//        errors.filter {
//
//
//        }

        return errors
   }

}