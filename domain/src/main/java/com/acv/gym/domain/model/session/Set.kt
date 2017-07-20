package com.acv.gym.domain.model.session

import com.acv.gym.domain.model.Model
import java.util.*


data class Set(
        val id: SetId = SetId(),
        val weight: Float = 0f,
        val reps: Int = 0,
        val sessionExercise: SessionExerciseId
) : Model

data class SetId(
        val value: String = UUID.randomUUID().toString()
)
