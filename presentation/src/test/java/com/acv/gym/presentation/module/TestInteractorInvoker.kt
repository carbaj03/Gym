package com.acv.gym.presentation.module

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import kategory.Either
import kategory.Option

object TestInteractorInvoker {

    fun create(command: Any = EmptyCommand): UseCaseInvoker {
        val interactorInvoker = mock<UseCaseInvoker>()

        doAnswer {
            val execution = it.arguments[0] as UseCase<EmptyCommand, GenericError, Any>

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

    private fun anyInteractorExecution(): UseCase<EmptyCommand, GenericError, Any> = any()
}
