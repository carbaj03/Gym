package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.service.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface MuscleGroupView : GymView, ViewShow<MuscleGroup>, ViewError {
    fun goToExerciseType(id: Id)
}
