package com.acv.gym.domain.model.session

import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.model.exercise.ExerciseId
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.service.Id
import java.util.*

data class SessionExercise(
        val id: SessionExerciseId = SessionExerciseId(),
        val exercise: Exercise = Exercise(ExerciseId(""), "", "", ""),
        val sets: List<Set> = listOf(),
        val session: Id = Id("")
) : Model

data class SessionExerciseId(
        val value: String = UUID.randomUUID().toString()
)