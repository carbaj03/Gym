package com.acv.gym.data.local

import com.acv.gym.data.RoutinesDataSource
import com.acv.gym.domain.model.RoutineModel


class RoutinesDataSourceImpl : RoutinesDataSource {
    override fun getAll() = listOf(RoutineModel("1", "Full Body", ""),
            RoutineModel("2", "Torso/Pierna", ""), RoutineModel("3", "Push/Pull/Leg", ""))
}