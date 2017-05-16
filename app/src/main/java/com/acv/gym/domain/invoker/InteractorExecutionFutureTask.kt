package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.usecase.Command
import com.acv.gym.presentation.invoker.InteractorExecution
import com.jmpergar.futurek.Future
import katz.Either

class InteractorExecutionFutureTask<I : Command, E : GenericExceptions, R : List<Model>>(
        val interactorExecution: InteractorExecution<I, E, R>
) {
    lateinit private var future: Future<Either<E, R>>

    fun init() {
        future = Future { interactorExecution.interactor.execute(interactorExecution.params) }
        future.onComplete { renderFeedResult(it) }
    }

    private fun renderFeedResult(result: Either<E, R>): Any =
            when (result) {
                is Either.Left -> handleError(result.a)
                is Either.Right -> handleResult(result.b)
            }

    private fun handleResult(result: R) {
        interactorExecution.interactorResult(result)
    }

    private fun handleError(result: E) {
        interactorExecution.interactorError(result)
    }
}
