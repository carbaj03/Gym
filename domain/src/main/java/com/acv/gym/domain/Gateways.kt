package com.acv.gym.domain

import com.acv.gym.domain.model.*
import com.acv.gym.domain.usecase.Id
import katz.Either


interface SharedPreference {
    fun getLaunchApp(): Either<GenericError, List<LaunchApp>>
}

interface GymGateway {
    fun getExercise(id: Id): GymResult<List<Exercise>>
    fun getAllSesion(): GymResult<List<Session>>
    fun getSessionExercisesBy(id: Id): GymResult<List<SessionExercise>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllRoutines(): GymResult<List<Routine>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
    fun persistSessionExercise(sessionExercises: List<SessionExercise>): GymResult<List<SessionExercise>>
}