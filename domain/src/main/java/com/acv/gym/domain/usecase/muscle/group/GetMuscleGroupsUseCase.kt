package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import katz.Option

open class GetMuscleGroupsUseCase(
        val muscleGroupGateway: GymGateway
) : GymUseCase<Command, List<MuscleGroup>> {
    override fun execute(input: Option<Command>) = muscleGroupGateway.getAllMuscleGroups()
}