package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.ExerciseTypeDataModel


open class ExerciseTypeLocalDataSource : DataSource<ExerciseTypeDataModel> {
    override fun getAll() = listOf(ExerciseTypeDataModel("1", "Pecho"),
            ExerciseTypeDataModel("2", "Espalda"),
            ExerciseTypeDataModel("3", "Pierna"))
}