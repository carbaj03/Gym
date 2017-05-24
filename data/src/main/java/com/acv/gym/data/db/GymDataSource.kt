package com.acv.gym.data.db

import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
interface GymDataSource {
    fun getAllSession(): GymResult<List<Session>>
    fun getExercise(id: Id<String>): GymResult<List<Exercise>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllRoutines(): GymResult<List<Routine>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
    fun persistSessionExercises(sessionExercises: List<SessionExercise>): GymResult<List<SessionExercise>>
    fun getLaunchApp(): GymResult<List<LaunchApp>>
}