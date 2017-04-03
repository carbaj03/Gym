package com.acv.gym.presentation.core


import org.funktionale.either.Disjunction

class InteractorInvokerImp : InteractorInvoker {
    override fun <I, E, R> execute(interactor: InteractorExecution<I, E, R>) =  InteractorExecutionFutureTask(interactor).init()
}