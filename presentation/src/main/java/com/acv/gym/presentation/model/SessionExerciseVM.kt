package com.acv.gym.presentation.model

import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id

data class SessionExerciseVM(
        val id: Id = Id(),
        val exercise: String,
        val sets: List<SessionSetVM> = listOf(),
        val session: Id = Id("")
) : ViewModel

fun SessionExercise.map() = SessionExerciseVM(id, exercise.name, sets.map { it.map() }, session)