package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.ExerciseTypeDataModel


open class ExerciseTypeLocalDataSource : DataSource<ExerciseTypeDataModel> {
    override fun getAll() = listOf(
            ExerciseTypeDataModel("1", "Dumbell"),
            ExerciseTypeDataModel("2", "Bar"),
            ExerciseTypeDataModel("3", "Cable"),
            ExerciseTypeDataModel("4", "Body Weight"),
            ExerciseTypeDataModel("4", "Machine")
    )
}