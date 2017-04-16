package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.UseCase

open class GetMuscleGroupsUseCase(val muscleGroupGateway: MuscleGroupLocalGateway) :
        UseCase<EmptyCommand, List<MuscleGroupModel>, GenericExceptions> {

    override fun execute(input: EmptyCommand) = muscleGroupGateway.obtain()
}