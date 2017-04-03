package com.acv.gym.domain.invoker

import com.acv.gym.presentation.core.Future
import com.acv.gym.presentation.invoker.InteractorExecution
import org.funktionale.either.Disjunction

class InteractorExecutionFutureTask<I, E, R>(val interactorExecution: InteractorExecution<I, E, R>) {

    lateinit private var future : Future<Disjunction<E, R>>

    fun init() {
        future = Future { interactorExecution.interactor.execute(interactorExecution.algo) }
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
        interactorExecution.interactorError(result)
    }

}
