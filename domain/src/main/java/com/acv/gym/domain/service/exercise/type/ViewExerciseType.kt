package com.acv.gym.domain.service.exercise.type

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.service.ExerciseTypeCommand
import com.acv.gym.domain.service.GymUseCase
import kategory.Either
import kategory.Option


open class ViewExerciseType(
        val gateway: GymGateway
) : GymUseCase<ExerciseTypeCommand, List<ExerciseType>> {
    override fun execute(input: Option<ExerciseTypeCommand>) = when (input) {
        is Option.None -> Either.Left(GenericError.NetworkError)
        is Option.Some -> gateway.getExerciseTypesBy(input.value.id)
    }
}