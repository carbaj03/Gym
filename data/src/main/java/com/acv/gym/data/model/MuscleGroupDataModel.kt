package com.acv.gym.data.model

import com.acv.gym.domain.model.MuscleGroupModel


data class MuscleGroupDataModel(val id: String,
                                val name: String) : DataModel

fun MuscleGroupDataModel.map() = MuscleGroupModel(id, name)

