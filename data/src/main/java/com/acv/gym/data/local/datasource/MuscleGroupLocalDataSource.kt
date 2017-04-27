package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.MuscleGroupDataModel


class MuscleGroupLocalDataSource: DataSource<MuscleGroupDataModel> {
    override fun getAll() = listOf(MuscleGroupDataModel("1", "Pecho"),
            MuscleGroupDataModel("2", "Espalda"),
            MuscleGroupDataModel("3", "Pierna"))
}