package com.acv.gym.data.db

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.*
import katz.Either
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
interface GymDataSource {
    fun getExercise(id: Id<String>): Either<GenericExceptions, List<Exercise>>
    fun getAllExercises(): Either<GenericExceptions, List<Exercise>>
    fun getAllMuscleGroups(): Either<GenericExceptions, List<MuscleGroup>>
    fun getAllRoutines(): Either<GenericExceptions, List<Routine>>
    fun getAllSessionExercises(): Either<GenericExceptions, List<SessionExercise>>
    fun getLaunchApp(): Either<GenericExceptions, List<LaunchApp>>
}