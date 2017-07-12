package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.service.Command
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker


class InteractorInvokerImp : ServiceInvoker {
    override fun <I : Command, E : GenericError, R> execute(interactor: Logic<I, E, R>) =
            InteractorExecutionFutureTask(interactor).init()
}