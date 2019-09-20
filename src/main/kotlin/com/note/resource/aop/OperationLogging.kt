package com.note.resource.aop

import com.note.resource.common.logger.Log
import graphql.servlet.input.GraphQLSingleInvocationInput
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Component
@Aspect
class OperationLogging {

    companion object: Log()

    @Before(value ="execution(* graphql.servlet.core.GraphQLQueryInvoker.query(..)) && args(singleInvocationInput)")
    fun operationNameLogging(singleInvocationInput: GraphQLSingleInvocationInput){
        logger.info("operationName -> ${singleInvocationInput.executionInput.operationName}")

    }

}