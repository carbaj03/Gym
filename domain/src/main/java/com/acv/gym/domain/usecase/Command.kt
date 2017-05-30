package com.acv.gym.domain.usecase

import com.acv.gym.domain.commons.extension.now
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import java.io.Serializable
import java.util.*

sealed class Command : Serializable

object EmptyCommand : Command()

data class Id(
        val value: String = UUID.randomUUID().toString()
) : Command()

data class ExerciseCommand(
        val id: Id
) : Command()

data class SessionCommand(
        val id: Id
) : Command()

data class NewSessionCommand(
        val sessionExercises: List<SessionExercise>
) : Command()


data class SplashCommand(
        val any: Any
) : Command()

