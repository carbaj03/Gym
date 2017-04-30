package com.acv.gym.presentation.module

import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import katz.Either

object TestInteractorInvoker {

    fun create(command: Any = EmptyCommand()): InteractorInvoker {
        val interactorInvoker = mock<InteractorInvoker>()

        doAnswer { invocationOnMock ->
            val execution = invocationOnMock.arguments[0] as InteractorExecution<Any, Any, Any>
            val response = execution.interactor.execute(command)

            when (response) {
                is Either.Left -> execution.interactorError(response.a)
                is Either.Right -> execution.interactorResult(response.b)
            }
        }.`when`(interactorInvoker).execute(anyInteractorExecution())
        return interactorInvoker
    }

    private fun anyInteractorExecution(): InteractorExecution<Any, Any, Any> = any()
}
