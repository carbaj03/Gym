package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Session

data class SessionCache(
        val id: String,
        val name: String
) : DataModel

fun SessionCache.map() = Session(id, name)
