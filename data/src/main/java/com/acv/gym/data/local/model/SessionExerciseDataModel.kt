package com.acv.gym.data.local.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise


data class SessionExerciseDataModel(
        val id: String,
        val exercise: String,
        val sets: List<SessionSetDataModel>,
        val session: String
) : DataModel

fun SessionExerciseDataModel.map() = SessionExercise(id, exercise, sets.map { it.map() }, session)