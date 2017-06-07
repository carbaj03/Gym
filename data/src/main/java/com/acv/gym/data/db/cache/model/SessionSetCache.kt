package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id

data class SessionSetCache(
        val id: String,
        val weight: Float,
        val reps: Int,
        val sessionExercise: String
): DataModel

fun SessionSetCache.map() = SessionSet(Id(id), weight, reps, Id(sessionExercise))
fun SessionSet.map() = SessionSetCache(id.value, weight, reps, sessionExercise.value)