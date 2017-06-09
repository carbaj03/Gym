package com.acv.gym.domain.usecase

import com.acv.gym.domain.model.SessionExercise
import java.io.Serializable
import java.util.*

sealed class Command : Serializable

object EmptyCommand : Command()

data class Activity(
        val value: Command
) : Command()


data class Id(
        val value: String = UUID.randomUUID().toString()
) : Command()

data class ExerciseCommand(
        val idMuscleGroup: Id,
        val idExerciseType: Id
) : Command()

data class ExerciseTypeCommand(
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

