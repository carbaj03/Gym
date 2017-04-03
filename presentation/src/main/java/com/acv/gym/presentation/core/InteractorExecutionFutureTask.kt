package com.acv.gym.presentation.core

import org.funktionale.either.Disjunction

class InteractorExecutionFutureTask<I, E, R>(val interactorExecution: InteractorExecution<I, E, R>) {

    init {
        val future = Future { interactorExecution.interactor.execute(interactorExecution.algo) }
        future.onComplete { renderFeedResult(it) }
    }

    fun init(){
        val future = Future { interactorExecution.interactor.execute(interactorExecution.algo) }
        future.onComplete { renderFeedResult(it) }
    }

    private fun renderFeedResult(result: Disjunction<E, R>): Any =
            when (result) {
                is Disjunction.Left -> handleError(result.swap().get())
                is Disjunction.Right -> result.map { handleResult(it) }
            }

    private fun handleResult(result: R) {
        interactorExecution.interactorResult(result)
    }

    private fun handleError(result: E) {
        interactorExecution.error(result)
    }

}
