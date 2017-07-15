package com.acv.gym.domain.model.exercise

import com.acv.gym.domain.model.Model
import java.util.*


data class Exercise(
        val id: ExerciseId,
        val name: String,
        val exerciseType: String,
        val muscleGroup: String
) : Model

data class ExerciseId(
        val value: String = UUID.randomUUID().toString()
)