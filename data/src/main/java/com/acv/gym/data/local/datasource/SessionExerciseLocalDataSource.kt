package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.SessionExerciseDataModel


class SessionExerciseLocalDataSource : DataSource<SessionExerciseDataModel> {
    override fun getAll() = listOf(SessionExerciseDataModel("1", "1", 20f, 10, "1"),
            SessionExerciseDataModel("2", "1", 20f, 10, "1"),
            SessionExerciseDataModel("3", "1", 20f, 10, "1"))
}