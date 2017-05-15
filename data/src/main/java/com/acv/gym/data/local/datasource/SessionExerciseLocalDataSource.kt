package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.SessionExerciseDataModel
import com.acv.gym.data.local.model.SessionSetDataModel


open class SessionExerciseLocalDataSource : DataSource<SessionExerciseDataModel> {
    override fun getAll() = listOf(
            SessionExerciseDataModel("1",
                    "Press Banca Plano",
                    listOf(
                            SessionSetDataModel("1", 20f, 10, ""),
                            SessionSetDataModel("2", 20f, 10, "")
                    ),
                    "1"),
            SessionExerciseDataModel("2",
                    "Militar DB",
                    listOf(
                            SessionSetDataModel("1", 20f, 10, ""),
                            SessionSetDataModel("2", 20f, 10, "")
                    ),
                    "1"),
            SessionExerciseDataModel("3",
                    "Press Inclinado DB",
                    listOf(
                            SessionSetDataModel("1", 20f, 10, ""),
                            SessionSetDataModel("2", 20f, 10, "")
                    ),
                    "1")
    )
}