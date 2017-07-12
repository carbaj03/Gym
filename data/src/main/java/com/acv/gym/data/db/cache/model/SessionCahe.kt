package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Session
import com.acv.gym.domain.model.SessionId
import com.acv.gym.domain.usecase.Id
import java.util.*

data class SessionCache(
        val id: String,
        val name: String,
        val date: Date
) : DataModel

fun SessionCache.map() = Session(SessionId(id), name, date)
