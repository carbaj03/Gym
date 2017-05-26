package com.acv.gym.domain.usecase.session


import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import com.acv.gym.domain.usecase.NewSessionCommand
import katz.Option

open class NewSessionExerciseUseCase(
        val gateway: GymGateway
) : GymUseCase<NewSessionCommand, List<SessionExercise>> {
    override fun execute(input: Option<NewSessionCommand>) = TODO()
}