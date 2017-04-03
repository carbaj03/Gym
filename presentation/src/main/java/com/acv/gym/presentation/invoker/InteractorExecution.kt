package com.acv.gym.presentation.invoker

import com.acv.gym.domain.usecase.UseCase
import com.acv.gym.presentation.invoker.InteractorInvoker


open class InteractorExecution<I, E, R>(val interactor: UseCase<I, R, E>, val params: I) {
    lateinit var interactorResult: (R) -> Any
        private set

    lateinit var interactorError: (E) -> Any
        private set

    fun result(body: (R) -> Any): InteractorExecution<I, E, R> {
        this.interactorResult = body
        return this
    }

    fun errorResult(body: (E) -> Any): InteractorExecution<I, E, R> {
        this.interactorError = body
        return this
    }

    fun execute(interactorInvoker: InteractorInvoker) {
        interactorInvoker.execute(this)
    }
}
