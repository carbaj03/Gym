package com.acv.gym.presentation.invoker

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.usecase.Command


interface InteractorInvoker {
    fun <I : Command, E : GenericExceptions, R : List<Model>> execute(interactor: InteractorExecution<I, E, R>)
}
