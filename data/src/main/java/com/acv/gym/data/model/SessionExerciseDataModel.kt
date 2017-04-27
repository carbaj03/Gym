package com.acv.gym.data.model

import com.acv.gym.domain.model.SessionExerciseModel

data class SessionExerciseDataModel(val id: String,
                                    val exercise: String,
                                    val weight: Float,
                                    val reps: Int,
                                    val session: String) : DataModel

fun SessionExerciseDataModel.map() = SessionExerciseModel(id, exercise, weight, reps, session)