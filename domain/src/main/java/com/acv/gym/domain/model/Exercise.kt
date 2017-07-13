package com.acv.gym.domain.model

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