package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.presentation.View

interface MuscleGroupView : View {
    fun show(muscleGroups: List<MuscleGroupModel>)
    fun showNetworkError()
    fun showServerError()
}
