package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import com.acv.gym.domain.usecase.SessionCommand
import katz.Either
import katz.Option

open class GetSessionSetUseCase(
        val gateway: GymGateway
) : GymUseCase<SessionCommand, List<SessionSet>> {
    override fun execute(input: Option<SessionCommand>) = when(input){
        is Option.None -> Either.Left(GenericError.NetworkError())
        is Option.Some -> gateway.getSessionSetBy(input.value.id)
    }
}