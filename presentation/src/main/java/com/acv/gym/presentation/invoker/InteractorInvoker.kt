package com.acv.gym.presentation.invoker


import com.acv.gym.presentation.invoker.InteractorExecution
import org.funktionale.either.Disjunction

interface InteractorInvoker {
    fun <I, E, R> execute(interactor: InteractorExecution<I, E, R>)
}
