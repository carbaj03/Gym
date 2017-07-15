package com.acv.gym.domain.model.exercise

import com.acv.gym.domain.model.Model
import java.util.*

data class ExerciseType(
        val id: ExerciseTypeId,
        val name: String
) : Model

data class ExerciseTypeId(
        val value: String = UUID.randomUUID().toString()
)