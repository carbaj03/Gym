package com.acv.gym.domain.model

import com.acv.gym.domain.usecase.Id
import java.util.*


data class Session(
        val id: Id,
        val name: String,
        val date: Date
) : Model