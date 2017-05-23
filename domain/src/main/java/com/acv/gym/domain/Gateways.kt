package com.acv.gym.domain

import com.acv.gym.domain.model.*
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Id
import katz.Option


interface BaseGateway<in I, out E, out S> {
    fun obtain(command: Option<I>): Either<E, List<S>>
    fun persist(list: List<I>): Either<E, List<S>>
}

interface GenericGateway<out O : Model> : BaseGateway<Command, GenericExceptions, O>

interface ExerciseGateway : GenericGateway<Exercise>
interface ExerciseTypeGateway : GenericGateway<ExerciseType>
interface LaunchAppGateway : GenericGateway<LaunchApp>
interface MuscleGroupGateway : GenericGateway<MuscleGroup>
interface RoutineGateway : GenericGateway<Routine>
interface SessionGateway : GenericGateway<SessionExercise>


interface GymGateway {
    fun getExercise(id: Id<String>): Either<GenericExceptions, List<Exercise>>
    fun getAllExercises(): Either<GenericExceptions, List<Exercise>>
    fun getAllMuscleGroups(): Either<GenericExceptions, List<MuscleGroup>>
    fun getAllRoutines(): Either<GenericExceptions, List<Routine>>
    fun getAllSessionExercises(): Either<GenericExceptions, List<SessionExercise>>
    fun getLaunchApp(): Either<GenericExceptions, List<LaunchApp>>
}