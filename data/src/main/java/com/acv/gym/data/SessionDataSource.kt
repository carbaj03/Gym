package com.acv.gym.data

import com.acv.gym.domain.model.SessionExerciseModel


interface SessionDataSource {
    fun getAllBy(date: String): List<SessionExerciseModel>
}