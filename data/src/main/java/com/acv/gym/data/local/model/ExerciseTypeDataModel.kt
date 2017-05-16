package com.acv.gym.data.local.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.ExerciseType

data class ExerciseTypeDataModel(
        val id : String,
        val name : String
) : DataModel

fun ExerciseTypeDataModel.map() = ExerciseType(id, name)
