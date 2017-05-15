package com.acv.gym.data.local.model

import com.acv.gym.data.DataModel


data class MuscleGroupDataModel(val id: String,
                                val name: String) : DataModel

fun com.acv.gym.data.local.model.MuscleGroupDataModel.map() = com.acv.gym.domain.model.MuscleGroup(id, name)

