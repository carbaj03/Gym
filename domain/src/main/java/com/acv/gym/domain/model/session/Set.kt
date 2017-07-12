package com.acv.gym.domain.model.session

import com.acv.gym.domain.model.Model
import com.acv.gym.domain.service.Id


data class Set(
        val id: Id = Id(),
        val weight: Float = 0f,
        val reps: Int = 0,
        val sessionExercise: Id
) : Model