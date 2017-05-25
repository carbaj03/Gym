package com.acv.gym.presentation.invoker

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.Command


interface InteractorInvoker {
    fun <I: Command, E: GenericError, R> execute(interactor: InteractorExecution<I, E, R>)
}
