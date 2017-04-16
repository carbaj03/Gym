package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.presentation.View

interface ExerciseTypeView : View {
    fun show(muscleGroups: List<ExerciseTypeModel>)
    fun showNetworkError()
    fun showServerError()
}
