package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import org.funktionale.either.Disjunction

open class GetExerciseTypesUseCase : UseCase<Command, List<ExerciseTypeModel>, GenericExceptions> {
    override fun execute(input: Command): Disjunction<GenericExceptions, List<ExerciseTypeModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}