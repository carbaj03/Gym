package com.acv.gym.presentation.invoker

import com.acv.gym.domain.usecase.UseCase
import katz.Option


open class InteractorExecution<I, E, R>(
        val interactor: UseCase<I, R, E>, val params: Option<I> = Option.None
) {
    lateinit var interactorResult: (R) -> Unit
        private set

    lateinit var interactorError: (E) -> Unit
        private set

    fun result(body: (R) -> Unit): InteractorExecution<I, E, R> {
        interactorResult = body
        return this
    }

    fun errorResult(body: (E) -> Unit): InteractorExecution<I, E, R> {
        interactorError = body
        return this
    }

    fun execute(interactorInvoker: InteractorInvoker) {
        interactorInvoker.execute(this)
    }
}
