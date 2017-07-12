package com.acv.gym.domain.service.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.GymUseCase
import com.acv.gym.domain.service.SessionCommand
import kategory.Either
import kategory.Option

open class ViewSet(
        val gateway: GymGateway
) : GymUseCase<SessionCommand, List<Set>> {
    override fun execute(input: Option<SessionCommand>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getSessionSetBy(input.value.id)
    }
}