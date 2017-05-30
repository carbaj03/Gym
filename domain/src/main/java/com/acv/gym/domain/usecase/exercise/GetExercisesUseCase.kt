package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.GymUseCase
import katz.Id
import katz.Option


open class GetExercisesUseCase(
        val gateway: GymGateway
) : GymUseCase<ExerciseCommand, List<Exercise>> {

    override fun execute(input: Option<ExerciseCommand>) = gateway.getAllExercises()
}