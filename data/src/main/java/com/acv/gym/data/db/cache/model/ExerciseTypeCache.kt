package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.exercise.ExerciseType
import com.acv.gym.domain.model.exercise.ExerciseTypeId

data class ExerciseTypeCache(
        val id : String,
        val name : String
) : DataModel

fun ExerciseTypeCache.map() = ExerciseType(ExerciseTypeId(id), name)
