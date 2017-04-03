package com.acv.gym.presentation.splash

import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import org.funktionale.either.Disjunction

object TestInteractorInvoker {

    fun create(): InteractorInvoker {
        val interactorInvoker = mock<InteractorInvoker>()

        doAnswer { invocationOnMock ->
            val execution = invocationOnMock.arguments[0] as InteractorExecution<Any, Any, Any>
            val response = execution.interactor.execute(Any())

            when (response) {
                is Disjunction.Left -> execution.interactorError(response.swap().get())
                is Disjunction.Right -> execution.interactorResult(response.value)
            }
        }.`when`(interactorInvoker).execute(anyInteractorExecution())
        return interactorInvoker
    }

    private fun anyInteractorExecution(): InteractorExecution<Any, Any, Any> = any()
}
