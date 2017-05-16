package com.acv.gym.domain.invoker

import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


class InteractorInvokerImp : InteractorInvoker {
    override fun <I, E, R> execute(interactor: InteractorExecution<I, E, R>)
            = InteractorExecutionFutureTask(interactor).init()
}