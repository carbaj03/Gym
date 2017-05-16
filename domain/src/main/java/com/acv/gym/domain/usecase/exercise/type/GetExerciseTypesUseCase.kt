package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.ExerciseTypeGateway
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option


open class GetExerciseTypesUseCase(
        val gateway: ExerciseTypeGateway
) : UseCase<Command, List<ExerciseType>, GenericExceptions> {
    override fun execute(input: Option<Command>) = gateway.obtain(input)
}