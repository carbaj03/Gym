package com.acv.gym.presentation.model

import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id


data class SessionSetVM(
        val id: Id = Id(),
        val name: String
) : ViewModel

fun Set.map() = SessionSetVM(id, "$weight / $reps")