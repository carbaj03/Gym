package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.model.session.SetId
import com.acv.gym.domain.service.Id

data class SessionSetCache(
        val id: String,
        val weight: Float,
        val reps: Int,
        val sessionExercise: String
): DataModel

fun SessionSetCache.map() = Set(SetId(id), weight, reps, Id(sessionExercise))
fun Set.map() = SessionSetCache(id.value, weight, reps, sessionExercise.value)