package com.acv.gym.domain.invoker

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.usecase.Command
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


class InteractorInvokerImp : InteractorInvoker {
    override fun <I : Command, E : GenericExceptions, R : List<Model>> execute(interactor: InteractorExecution<I, E, R>)
            = InteractorExecutionFutureTask(interactor).init()
}