package com.acv.gym.presentation.module.session.set

import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow
import com.acv.gym.presentation.model.SessionSetVM

interface SessionSetView : GymView, ViewShow<SessionSetVM>, ViewError {
    fun showClick(id: Id)
}
