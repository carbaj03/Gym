package com.acv.gym.domain.service.session


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.session.SessionId
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.model.session.SetId
import com.acv.gym.domain.service.GymUseCase
import com.acv.gym.domain.service.Request
import com.acv.gym.domain.service.SessionCommand
import kategory.Either
import kategory.Option

open class ViewSet(
        val gateway: GymGateway
) : GymUseCase<ViewSetRequest, List<Set>> {
    override fun execute(input: Option<ViewSetRequest>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getSessionSetBy(input.value.idSet)
    }
}

data class ViewSetRequest(
        val idSet: SetId
) : Request