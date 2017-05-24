package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise

data class ExerciseCache(
        val id: String,
        val name: String,
        val exerciseType: String
) : DataModel

fun ExerciseCache.map() = Exercise(id, name, exerciseType)
