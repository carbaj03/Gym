package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.ExerciseId

data class ExerciseCache(
        val id: String,
        val name: String,
        val exerciseType: String,
        val muscleGroup: String
) : DataModel

fun ExerciseCache.map() = Exercise(ExerciseId(id), name, exerciseType, muscleGroup)
