package com.acv.gym.domain.model.session

import com.acv.gym.domain.model.Model
import java.util.*

data class Session(
        val id: SessionId,
        val name: String,
        val date: Date
) : Model

data class SessionId(
        val value: String = UUID.randomUUID().toString()
)