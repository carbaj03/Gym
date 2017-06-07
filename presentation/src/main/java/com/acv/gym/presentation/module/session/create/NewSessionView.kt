package com.acv.gym.presentation.module.session.create

import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError

interface NewSessionView : GymView, ViewError {
    fun showSuccess()
}
