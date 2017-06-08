package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.ExerciseType

data class ExerciseTypeCache(
        val id : String,
        val name : String
) : DataModel

fun ExerciseTypeCache.map() = ExerciseType(id, name)
