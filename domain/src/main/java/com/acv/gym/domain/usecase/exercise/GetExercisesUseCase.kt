package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.GymUseCase
import katz.Either
import katz.Option


open class GetExercisesUseCase(
        val gateway: GymGateway
) : GymUseCase<ExerciseCommand, List<Exercise>> {

    override fun execute(input: Option<ExerciseCommand>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getExercisesBy(input.value.idMuscleGroup, input.value.idExerciseType)
    }
}