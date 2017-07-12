package com.acv.gym.presentation.module

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.service.EmptyCommand
import com.acv.gym.domain.service.EmptyRequest
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import kategory.Either
import kategory.Option

object TestInteractorInvoker {

    fun create(command: Any = EmptyRequest): ServiceInvoker {
        val interactorInvoker = mock<ServiceInvoker>()

        doAnswer {
            val execution = it.arguments[0] as Logic<EmptyRequest, GenericError, Any>

            with(execution) {
                val response = service.execute(Option.None)

                when (response) {
                    is Either.Left -> error(response.a)
                    is Either.Right -> result(response.b)
                }
            }

        }.`when`(interactorInvoker).execute(anyInteractorExecution())
        return interactorInvoker
    }

    private fun anyInteractorExecution(): Logic<EmptyRequest, GenericError, Any> = any()
}
