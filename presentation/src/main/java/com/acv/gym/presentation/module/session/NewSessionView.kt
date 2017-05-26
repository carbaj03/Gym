package com.acv.gym.presentation.module.session

import com.acv.gym.presentation.View
import com.acv.gym.presentation.ViewError

interface NewSessionView : View, ViewError {
    fun showSuccess()
}
