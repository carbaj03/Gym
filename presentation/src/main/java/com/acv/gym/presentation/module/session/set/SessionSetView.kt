package com.acv.gym.presentation.module.session.set

import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface SessionSetView : GymView, ViewShow<SessionSet>, ViewError {
    fun showClick(id: Id)
}
