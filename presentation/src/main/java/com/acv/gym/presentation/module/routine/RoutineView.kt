package com.acv.gym.presentation.module.routine

import com.acv.gym.domain.model.Routine
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface RoutineView : GymView, ViewShow<Routine>, ViewError{
    fun goToTemplate(id: String)
}
