package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.service.Id


data class SessionExerciseCache(
        val id: String,
        val exercise: ExerciseCache,
        val sets: List<SessionSetCache>,
        val session: String
) : DataModel

fun SessionExerciseCache.map() = SessionExercise(SessionExerciseId(id), exercise.map(), sets.map { it.map() }, Id(session))