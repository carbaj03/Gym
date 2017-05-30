package com.acv.gym.domain.model


data class SessionSet(
        val id: String = "",
        val weight: Float = 0f,
        val reps: Int = 0,
        val sessionExercise: String = ""
) : Model