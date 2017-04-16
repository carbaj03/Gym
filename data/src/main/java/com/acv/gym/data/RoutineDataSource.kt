package com.acv.gym.data

import com.acv.gym.domain.model.RoutineModel


interface RoutineDataSource {
    fun getAll(): List<RoutineModel>
}