package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.usecase.Command
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker


class InteractorInvokerImp : UseCaseInvoker {
    override fun <I : Command, E : GenericError, R> execute(interactor: UseCase<I, E, R>) =
            InteractorExecutionFutureTask(interactor).init()
}