package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.model.exercise.ExerciseType
import com.acv.gym.domain.service.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface ExerciseTypeView : GymView, ViewShow<ExerciseType>, ViewError {
    fun goToExercise(id: Id)
}
