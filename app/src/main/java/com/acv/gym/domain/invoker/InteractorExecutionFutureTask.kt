package com.acv.gym.domain.invoker

import com.acv.gym.domain.Future
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.Command
import com.acv.gym.presentation.invoker.UseCase
import kategory.Either

class InteractorExecutionFutureTask<I : Command, E : GenericError, R>(
        val interactorExecution: UseCase<I, E, R>
) {
    fun init() = with(Future { callUseCases() }) { onComplete { renderFeedResult(it) } }

    private fun callUseCases() = with(interactorExecution) { interactor.execute(params) }

    private fun renderFeedResult(result: Either<E, R>) = when (result) {
        is Either.Left -> interactorExecution.error(result.a)
        is Either.Right -> interactorExecution.result(result.b)
    }
}