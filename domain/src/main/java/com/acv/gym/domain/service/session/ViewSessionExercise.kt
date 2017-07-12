package com.acv.gym.domain.service.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionId
import com.acv.gym.domain.service.GymUseCase
import com.acv.gym.domain.service.Request
import kategory.Either
import kategory.Option

open class ViewSessionExercise(
        val gateway: GymGateway
) : GymUseCase<ViewSessionExerciseRequest, List<SessionExercise>> {
    override fun execute(input: Option<ViewSessionExerciseRequest>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getSessionExercisesBy(input.value.idSession)
    }
}

data class ViewSessionExerciseRequest(
        val idSession: SessionId
) : Request