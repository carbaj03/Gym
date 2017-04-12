package com.acv.gym.data.local

import com.acv.gym.data.SessionDataSource
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.model.SessionExerciseModel


class SessionDataSourceImpl : SessionDataSource {
    override fun getAll() = listOf(SessionExerciseModel("1", "1" , 20f, 10, "1"),
            SessionExerciseModel("2", "1" , 20f, 10, "1"), SessionExerciseModel("2", "1" , 20f, 10, "1"))
}