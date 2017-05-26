package com.acv.gym.domain.usecase

import com.acv.gym.domain.commons.extension.now
import com.acv.gym.domain.model.SessionExercise
import java.io.Serializable
import java.util.*

sealed class Command : Serializable

object EmptyCommand : Command()

data class Id(
        val value: String
) : Command()

data class ExerciseCommand(
        val id: String
) : Command()

data class SessionCommand(
        val date: String = Calendar.getInstance().now()
) : Command()

data class NewSessionCommand(
        val sessionExercises: List<SessionExercise>
) : Command()


data class SplashCommand(
        val any: Any
) : Command()

