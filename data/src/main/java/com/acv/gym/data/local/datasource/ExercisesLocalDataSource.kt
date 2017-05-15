package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.ExerciseTypeDataModel
import com.acv.gym.data.model.ExerciseDataModel


open class ExercisesLocalDataSource : DataSource<ExerciseDataModel> {
    override fun getAll() = listOf(
            ExerciseDataModel("1", "Curl"),
            ExerciseDataModel("2", "Press Banca Plano"),
            ExerciseDataModel("3", "Dominadas"),
            ExerciseDataModel("4", "Dips"),
            ExerciseDataModel("5", "Squat")
    )
}