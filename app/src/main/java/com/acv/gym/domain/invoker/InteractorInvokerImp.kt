package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.Command
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


class InteractorInvokerImp : InteractorInvoker {
    override fun <I : Command, E : GenericError, R> execute(interactor: InteractorExecution<I, E, R>)
            = InteractorExecutionFutureTask(interactor).init()
}