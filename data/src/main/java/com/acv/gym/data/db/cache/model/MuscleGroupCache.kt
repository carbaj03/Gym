package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.MuscleGroup


data class MuscleGroupCache(
        val id: String,
        val name: String
) : DataModel

fun MuscleGroupCache.map() = MuscleGroup(id, name)

