package com.acv.gym.presentation.invoker

import com.acv.gym.domain.GenericError


import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

interface UseCaseInvoker {
    fun <I : Command, E : GenericError, R> execute(interactor: com.acv.gym.presentation.invoker.UseCase<I, E, R>)
}

open class UseCase<I : Command, E : GenericError, R>(
        val interactor: UseCase<I, R, E>,
        val params: Option<I> = Option.None,
        val result: (R) -> Unit,
        val error: (E) -> Unit
) {
    fun execute(interactorInvoker: UseCaseInvoker) = interactorInvoker.execute(this)
}

infix fun <I : Command, E : GenericError, R> UseCaseInvoker.invoke(interactor: com.acv.gym.presentation.invoker.UseCase<I, E, R>) =
        interactor.execute(this)
