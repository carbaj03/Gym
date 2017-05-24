package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.UseCase
import katz.Id
import katz.Option

open class GetExercisesUseCase(
        val gateway: GymGateway
) : UseCase<ExerciseCommand, List<Exercise>, GenericError> {
    override fun execute(input: Option<ExerciseCommand>) = gateway.getExercise(Id("1"))
}
