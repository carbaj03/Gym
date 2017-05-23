package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class GetSessionExercisesUseCase(
        val gateway: GymGateway
) : UseCase<Command, List<SessionExercise>, GenericExceptions> {
    override fun execute(input: Option<Command>) = gateway.getAllSessionExercises()
}