package com.acv.gym.presentation.module.session.create

import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError

interface NewSessionView : GymView, ViewError {
    fun showSuccess()
    fun showFab()
    fun goToExerciseType(id: Id)
    fun goToExercise(exerciseCommand: ExerciseCommand)
    fun goToWeight()
    fun goToReps()
}
