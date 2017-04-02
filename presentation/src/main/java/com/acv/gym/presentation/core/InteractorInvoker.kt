package com.acv.gym.presentation.core


import org.funktionale.either.Disjunction

interface InteractorInvoker {
    fun <I, E, R> execute(interactor: InteractorExecution<I, E, R>): Future<Disjunction<E, R>>
}
