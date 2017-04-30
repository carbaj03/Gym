package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExerciseTypeGateway
import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase

open class GetExerciseTypesUseCase(val gateway: ExerciseTypeGateway) :
        UseCase<Command, List<ExerciseTypeModel>, GenericExceptions> {
    override fun execute(input: Command) = gateway.obtain()
}