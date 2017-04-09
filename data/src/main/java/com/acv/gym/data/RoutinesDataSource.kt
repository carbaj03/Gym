package com.acv.gym.data

import com.acv.gym.domain.model.RoutineModel


interface RoutinesDataSource {
    fun getAll(): List<RoutineModel>
}