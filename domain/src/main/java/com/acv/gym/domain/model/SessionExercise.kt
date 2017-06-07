package com.acv.gym.domain.model

import com.acv.gym.domain.usecase.Id

data class SessionExercise(
        val id: Id = Id(),
        val exercise: Id = Id(""),
        val sets: List<SessionSet> = listOf(),
        val session: Id = Id("")
) : Model
