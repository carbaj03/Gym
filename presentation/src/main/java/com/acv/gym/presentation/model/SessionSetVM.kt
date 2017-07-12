package com.acv.gym.presentation.model

import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.service.Id


data class SessionSetVM(
        val id: Id = Id(),
        val name: String
) : ViewModel

fun SessionSet.map() = SessionSetVM(id, "$weight / $reps")