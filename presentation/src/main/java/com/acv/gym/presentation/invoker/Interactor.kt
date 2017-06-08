package com.acv.gym.presentation.invoker

import com.acv.gym.domain.GenericError


import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

interface InteractorInvoker {
    fun <I : Command, E : GenericError, R> execute(interactor: Interactor<I, E, R>)
}

open class Interactor<I : Command, E : GenericError, R>(
        val interactor: UseCase<I, R, E>,
        val params: Option<I> = Option.None,
        val result: (R) -> Unit,
        val error: (E) -> Unit
) {
    fun execute(interactorInvoker: InteractorInvoker) = interactorInvoker.execute(this)
}

infix fun <I : Command, E : GenericError, R> InteractorInvoker.invoke(interactor: Interactor<I, E, R>) =
        interactor.execute(this)
