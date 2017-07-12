package com.acv.gym.domain.service.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionId
import com.acv.gym.domain.service.GymUseCase
import com.acv.gym.domain.service.NewSessionCommand
import com.acv.gym.domain.service.Request
import kategory.Either
import kategory.Option

open class AddSessionExercise(
        val gateway: GymGateway
) : GymUseCase<AddSessionRequest, List<SessionExercise>> {
    override fun execute(input: Option<AddSessionRequest>) = when (input) {
        is Option.None -> Either.Left(GenericError.ServerError)
        is Option.Some -> { gateway.persistSessionExercise(input.value.sessionExercises) }
    }
}

data class AddSessionRequest(
        val sessionExercises: List<SessionExercise>
) : Request