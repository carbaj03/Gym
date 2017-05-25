package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import katz.Option

open class GetSessionExercisesUseCase(
        val gateway: GymGateway
) : GymUseCase<Command, List<SessionExercise>> {
    override fun execute(input: Option<Command>) = gateway.getAllSessionExercises()
}