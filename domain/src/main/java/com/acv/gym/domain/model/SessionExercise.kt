package com.acv.gym.domain.model

import com.acv.gym.domain.usecase.Id
import java.util.*

data class SessionExercise(
        val id: SessionExerciseId = SessionExerciseId(),
        val exercise: Exercise = Exercise("","","",""),
        val sets: List<SessionSet> = listOf(),
        val session: Id = Id("")
) : Model

data class SessionExerciseId(
        val value: String = UUID.randomUUID().toString()
)