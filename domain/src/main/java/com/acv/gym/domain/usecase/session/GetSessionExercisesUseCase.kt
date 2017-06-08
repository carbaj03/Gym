package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import com.acv.gym.domain.usecase.SessionCommand
import katz.Either
import katz.Option

open class GetSessionExercisesUseCase(
        val gateway: GymGateway
) : GymUseCase<SessionCommand, List<SessionExercise>> {
    override fun execute(input: Option<SessionCommand>) = when(input){
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getSessionExercisesBy(input.value.id)
    }
}