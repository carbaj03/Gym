package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet

data class SessionSetCache(
        val id: String,
        val weight: Float,
        val reps: Int,
        val sessionExercise: String
): DataModel

fun SessionSetCache.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetCache(id, weight, reps, sessionExercise)