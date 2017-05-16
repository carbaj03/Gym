package com.acv.gym.presentation.invoker

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option


open class InteractorExecution<I : Command, E : GenericExceptions, R : List<Model>>(
        val interactor: UseCase<I, R, E>, val params: Option<I> = Option.None
) {
    lateinit var interactorResult: (R) -> Any
        private set

    lateinit var interactorError: (E) -> Any
        private set

    fun result(body: (R) -> Any): InteractorExecution<I, E, R> {
        interactorResult = body
        return this
    }

    fun errorResult(body: (E) -> Any): InteractorExecution<I, E, R> {
        interactorError = body
        return this
    }

    fun execute(interactorInvoker: InteractorInvoker) {
        interactorInvoker.execute(this)
    }
}
