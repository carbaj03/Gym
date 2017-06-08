package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow


interface ExerciseView : GymView, ViewShow<Exercise>, ViewError {
    fun goToWeight(id: Id)
}