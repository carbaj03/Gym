package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.View
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface MuscleGroupView : View, ViewShow<MuscleGroup>, ViewError {
    fun goToExerciseType(id: Id)
}
