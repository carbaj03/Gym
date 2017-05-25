package com.acv.gym.presentation.module

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option

object TestInteractorInvoker {

    fun create(command: Any = EmptyCommand): InteractorInvoker {
        val interactorInvoker = mock<InteractorInvoker>()

        doAnswer {
            val execution = it.arguments[0] as InteractorExecution<EmptyCommand, GenericError, Any>

            with(execution) {
                val response = interactor.execute(Option.None)

                when (response) {
                    is Either.Left -> error(response.a)
                    is Either.Right -> result(response.b)
                }
            }

        }.`when`(interactorInvoker).execute(anyInteractorExecution())
        return interactorInvoker
    }

    private fun anyInteractorExecution(): InteractorExecution<EmptyCommand, GenericError, Any> = any()
}
