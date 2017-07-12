package com.acv.gym.domain.service.muscle.group

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.service.*
import kategory.Option

open class ViewMuscleGroup(
        val muscleGroupGateway: GymGateway
) : GymUseCase<Request, List<MuscleGroup>> {
    override fun execute(input: Option<Request>) = muscleGroupGateway.getAllMuscleGroups()
}