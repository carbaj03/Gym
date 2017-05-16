package com.acv.gym.domain

import com.acv.gym.domain.model.*
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option


interface BaseGateway<in I : Command, out E, S> {
    fun obtain(command: Option<I>): Either<E, List<S>>
    fun persist(list: List<S>): Either<E, List<S>>
}

interface GenericGateway<O : Model> : BaseGateway<Command, GenericExceptions, O>

interface ExerciseGateway : GenericGateway<Exercise>
interface ExerciseTypeGateway : GenericGateway<ExerciseType>
interface LaunchAppGateway : GenericGateway<LaunchApp>
interface MuscleGateway : GenericGateway<MuscleGroup>
interface RoutineGateway : GenericGateway<Routine>
interface SessionGateway : GenericGateway<SessionExercise>