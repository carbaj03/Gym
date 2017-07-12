package com.acv.gym.domain.service.muscle.group

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.service.Command
import com.acv.gym.domain.service.GymUseCase
import kategory.Option

open class GetMuscleGroupsUseCase(
        val muscleGroupGateway: GymGateway
) : GymUseCase<Command, List<MuscleGroup>> {
    override fun execute(input: Option<Command>) = muscleGroupGateway.getAllMuscleGroups()
}