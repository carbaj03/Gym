package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.MuscleGroupGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class GetMuscleGroupsUseCase(
        val muscleGroupGateway: MuscleGroupGateway
) : UseCase<Command, List<MuscleGroup>, GenericExceptions> {
    override fun execute(input: Option<Command>) = muscleGroupGateway.obtain(input)
}