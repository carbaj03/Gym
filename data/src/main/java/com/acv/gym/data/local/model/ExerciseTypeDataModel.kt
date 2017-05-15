package com.acv.gym.data.local.model

import com.acv.gym.data.DataModel

data class ExerciseTypeDataModel(val id : String, val name : String) : DataModel

fun com.acv.gym.data.local.model.ExerciseTypeDataModel.map() = com.acv.gym.domain.model.ExerciseType(id, name)
