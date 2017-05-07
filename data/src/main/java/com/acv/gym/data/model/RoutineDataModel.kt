package com.acv.gym.data.model

import com.acv.gym.domain.model.Routine


data class RoutineDataModel(val id : String,
                        val name : String,
                        val image : String): DataModel

fun RoutineDataModel.map() = Routine(id, name, image)
