package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.service.Command
import com.acv.gym.domain.service.Request
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker


class ServiceInvokerImp : ServiceInvoker {
    override fun <I : Request, E : GenericError, R> execute(service: Logic<I, E, R>) =
            ServiceExecutionFutureTask(service).init()
}