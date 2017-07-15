package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.model.exercise.ExerciseId

data class ExerciseCache(
        val id: String,
        val name: String,
        val exerciseType: String,
        val muscleGroup: String
) : DataModel

fun ExerciseCache.map() = Exercise(ExerciseId(id), name, exerciseType, muscleGroup)
