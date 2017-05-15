package com.acv.gym.data.local.model

import com.acv.gym.domain.model.SessionSet

data class SessionSetDataModel(val id: String,
                               val weight: Float,
                               val reps: Int,
                               val sessionExercise: String)

fun SessionSetDataModel.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetDataModel(id, weight, reps, sessionExercise)