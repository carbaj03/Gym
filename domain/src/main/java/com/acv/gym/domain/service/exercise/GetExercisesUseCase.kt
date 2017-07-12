package com.acv.gym.domain.service.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.GymUseCase
import kategory.Either
import kategory.Option


open class GetExercisesUseCase(
        val gateway: GymGateway
) : GymUseCase<ExerciseCommand, List<Exercise>> {

    override fun execute(input: Option<ExerciseCommand>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getExercisesBy(input.value.idMuscleGroup, input.value.idExerciseType)
    }
}