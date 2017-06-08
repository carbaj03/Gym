package com.acv.gym.domain.model


data class Exercise(
        val id: String,
        val name: String,
        val exerciseType: String,
        val muscleGroup: String
) : Model