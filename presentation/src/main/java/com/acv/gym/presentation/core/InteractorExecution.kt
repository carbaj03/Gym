package com.acv.gym.presentation.core

import com.acv.gym.domain.usecase.UseCase


open class InteractorExecution<I, E, R>(val interactor: UseCase<I, R, E>, val algo: I) {
    lateinit var interactorResult: (R) -> Any
        private set

    lateinit var error: (E) -> Any
        private set

    fun result(body: (R) -> Any): InteractorExecution<I, E, R> {
        this.interactorResult = body
        return this
    }

    fun error(body: (E) -> Any): InteractorExecution<I, E, R> {
        this.error = body
        return this
    }

    fun execute(interactorInvoker: InteractorInvoker) {
        interactorInvoker.execute(this)
    }
}
