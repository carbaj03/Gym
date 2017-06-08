package com.acv.gym.domain.model

import com.acv.gym.domain.usecase.Id


data class SessionSet(
        val id: Id = Id(),
        val weight: Float = 0f,
        val reps: Int = 0,
        val sessionExercise: Id
) : Model