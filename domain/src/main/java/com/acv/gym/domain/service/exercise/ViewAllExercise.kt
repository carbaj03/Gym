package com.acv.gym.domain.service.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.service.*
import kategory.Either
import kategory.Option


open class ViewAllExercise(
        val gateway: GymGateway
) : GymUseCase<ViewAllExerciseRequest, List<Exercise>> {
    override fun execute(input: Option<ViewAllExerciseRequest>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getExercisesBy(input.value.idMuscleGroup, input.value.idExerciseType)
    }
}

data class ViewAllExerciseRequest(
        val idMuscleGroup: Id,
        val idExerciseType: Id
) : Request