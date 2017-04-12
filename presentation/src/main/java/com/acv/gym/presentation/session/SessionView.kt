package com.acv.gym.presentation.session

import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.presentation.View

interface SessionView : View {
    fun show(sessionExercise: List<SessionExerciseModel>)
    fun renderNetworkError()
    fun renderServerError()
}
