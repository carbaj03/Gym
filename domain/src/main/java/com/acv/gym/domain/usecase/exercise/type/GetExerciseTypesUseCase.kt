package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import katz.Option


open class GetExerciseTypesUseCase(
        val gateway: GymGateway
) : GymUseCase<Command, List<ExerciseType>> {
    override fun execute(input: Option<Command>) = gateway.getAllExerciseTypes()
}