package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExercisesGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase

open class GetExercisesUseCase(
        val gateway: ExercisesGateway
): UseCase<Command, List<Exercise>, GenericExceptions> {
    override fun execute(input: Command) = gateway.obtain(input)
}