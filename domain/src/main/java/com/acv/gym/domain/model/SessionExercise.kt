package com.acv.gym.domain.model

data class SessionExercise(
        val id: String,
        val exercise: String,
        val sets: List<SessionSet>,
        val session: String
) : Model