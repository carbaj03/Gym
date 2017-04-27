package com.acv.gym.data.model

import com.acv.gym.domain.model.RoutineModel


data class RoutineDataModel(val id : String,
                        val name : String,
                        val image : String): DataModel

fun RoutineDataModel.map() = RoutineModel(id, name, image)
