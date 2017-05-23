package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet

data class SessionSetDataModel(
        val id: String,
        val weight: Float,
        val reps: Int,
        val sessionExercise: String
): DataModel

fun SessionSetDataModel.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetDataModel(id, weight, reps, sessionExercise)