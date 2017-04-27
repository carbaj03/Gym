package com.acv.gym.data.model

import com.acv.gym.domain.model.ExerciseTypeModel

data class ExerciseTypeDataModel(val id : String, val name : String) : DataModel

fun ExerciseTypeDataModel.map() = ExerciseTypeModel(id, name)
