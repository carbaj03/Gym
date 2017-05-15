package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.RoutineDataModel


open class RoutineLocalDataSource: DataSource<RoutineDataModel>{
    override fun getAll() = listOf(
            RoutineDataModel("1", "Full Body", ""),
            RoutineDataModel("2", "Torso/Pierna", ""),
            RoutineDataModel("3", "Push/Pull/Leg", "")
    )
}