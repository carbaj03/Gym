package com.acv.gym.data.db.cache.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id


data class SessionExerciseCache(
        val id: String,
        val exercise: ExerciseCache,
        val sets: List<SessionSetCache>,
        val session: String
) : DataModel

fun SessionExerciseCache.map() = SessionExercise(Id(id), exercise.map(), sets.map { it.map() }, Id(session))