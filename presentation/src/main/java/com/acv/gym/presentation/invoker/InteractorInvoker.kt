package com.acv.gym.presentation.invoker


interface InteractorInvoker {
    fun <I, E, R> execute(interactor: InteractorExecution<I, E, R>)
}
