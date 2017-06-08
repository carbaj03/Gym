package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Routine


data class RoutineCache(
        val id: String,
        val name: String,
        val image: String
) : DataModel

fun RoutineCache.map() = Routine(id, name, image)
