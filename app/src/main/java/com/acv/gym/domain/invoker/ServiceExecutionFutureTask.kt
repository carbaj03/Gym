package com.acv.gym.domain.invoker

import com.acv.gym.domain.Future
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.service.Command
import com.acv.gym.domain.service.Request
import com.acv.gym.presentation.invoker.Logic
import kategory.Either

class ServiceExecutionFutureTask<I : Request, E : GenericError, R>(
        val interactorExecution: Logic<I, E, R>
) {
    fun init() = with(Future { callUseCases() }) { onComplete { renderFeedResult(it) } }

    private fun callUseCases() = with(interactorExecution) { service.execute(params) }

    private fun renderFeedResult(result: Either<E, R>) = when (result) {
        is Either.Left -> interactorExecution.error(result.a)
        is Either.Right -> interactorExecution.result(result.b)
    }
}