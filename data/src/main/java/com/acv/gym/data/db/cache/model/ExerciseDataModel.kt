package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise

data class ExerciseDataModel(
        val id: String,
        val name: String
) : DataModel

fun ExerciseDataModel.map() = Exercise(id, name)
