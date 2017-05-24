package com.acv.gym.domain

import com.acv.gym.domain.model.*
import katz.Either
import katz.Id


interface SharedPreference {
    fun getLaunchApp(): Either<GenericError, List<LaunchApp>>
}

interface GymGateway {
    fun getExercise(id: Id<String>): GymResult<List<Exercise>>
    fun getAllSesion(): GymResult<List<Session>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllRoutines(): GymResult<List<Routine>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
}