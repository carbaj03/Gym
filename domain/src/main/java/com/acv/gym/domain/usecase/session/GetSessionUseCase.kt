package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionLocalGateway
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.domain.usecase.UseCase
import org.funktionale.either.Disjunction

open class GetSessionUseCase(val sessionLocalGateway: SessionLocalGateway) :
        UseCase<SessionCommand, List<SessionExerciseModel>, GenericExceptions> {
    override fun execute(input: SessionCommand): Disjunction<GenericExceptions, List<SessionExerciseModel>>
            = sessionLocalGateway.obtain(input.date)
}