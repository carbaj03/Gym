package com.acv.gym.presentation.model

import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id

data class SessionExerciseVM(
        val id: Id = Id(),
        val exercise: Id = Id(""),
        val sets: List<SessionSet> = listOf(),
        val session: Id = Id(""),
        val name : String
) : ViewModel

fun SessionExerciseVM.map() = SessionExercise(id, exercise, sets, session)
fun SessionExercise.map() = SessionExerciseVM(id, exercise, sets, session, "")