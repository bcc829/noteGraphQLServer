package com.note.resource.aop

import com.note.resource.common.logger.Log
import graphql.language.OperationDefinition
import graphql.parser.Parser
import graphql.servlet.input.GraphQLSingleInvocationInput
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class OperationLogging {

    companion object : Log()

    private val graphqlParser = Parser()

    @Around(value = "execution(* graphql.servlet.core.GraphQLQueryInvoker.query(..)) && args(singleInvocationInput)")
    fun operationNameLogging(joinPoint: ProceedingJoinPoint, singleInvocationInput: GraphQLSingleInvocationInput): Any? {

        val operationName = if(singleInvocationInput.executionInput.operationName == null){
            val document = graphqlParser.parseDocument(singleInvocationInput.executionInput.query)

            (document.definitions[0] as OperationDefinition).name

        } else singleInvocationInput.executionInput.operationName

        logger.info("OperationName -> $operationName")

        val beforeTimeStamp = System.currentTimeMillis()

        val returnObject = joinPoint.proceed()

        val afterTimeStamp = System.currentTimeMillis()

        logger.info("Execution time -> ${afterTimeStamp - beforeTimeStamp}")

        return returnObject
    }
}

