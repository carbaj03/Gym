package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionLocalGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.UseCase

open class GetSessionUseCase(val sessionLocalGateway: SessionLocalGateway) :
        UseCase<SessionCommand, List<SessionExercise>, GenericExceptions> {
    override fun execute(input: SessionCommand) = sessionLocalGateway.obtain(input)
}