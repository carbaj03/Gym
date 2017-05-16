package com.acv.gym.domain.model


data class SessionSet(
        val id: String,
        val weight: Float,
        val reps: Int,
        val sessionExercise: String
) : Model