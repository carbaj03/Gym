package com.acv.gym.data

import com.acv.gym.domain.model.SessionExerciseModel


interface SessionDataSource {
    fun getAll(): List<SessionExerciseModel>
}