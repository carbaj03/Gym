package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.UseCase

open class GetMuscleGroupsUseCase(val muscleGroupGateway: MuscleGroupLocalGateway) :
        UseCase<Command, List<MuscleGroup>, GenericExceptions> {

    override fun execute(input: Command) = muscleGroupGateway.obtain(input)
}