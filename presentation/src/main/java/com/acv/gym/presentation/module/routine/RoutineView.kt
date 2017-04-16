package com.acv.gym.presentation.module.routine

import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.presentation.View

interface RoutineView : View {
    fun show(routines : List<RoutineModel>)
    fun renderNetworkError()
    fun renderServerError()

    fun goToTemplate(id: String)
}
