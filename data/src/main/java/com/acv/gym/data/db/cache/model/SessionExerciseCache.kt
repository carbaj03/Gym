package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise


data class SessionExerciseCache(
        val id: String,
        val exercise: String,
        val sets: List<SessionSetCache>,
        val session: String
) : DataModel

fun SessionExerciseCache.map() = SessionExercise(id, exercise, sets.map { it.map() }, session)