package com.acv.gym.presentation.module.session

import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow
import com.acv.gym.presentation.model.SessionExerciseVM

interface SessionView : GymView, ViewShow<SessionExerciseVM>, ViewError {
    fun showClick(id: Id)
    fun enabledDeleteMode()
    fun disabledDeleteMode()
    fun goBack(): Boolean
}
