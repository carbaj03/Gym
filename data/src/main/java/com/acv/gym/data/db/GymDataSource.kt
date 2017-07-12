package com.acv.gym.data.db

import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import com.acv.gym.domain.model.session.Session
import com.acv.gym.domain.usecase.Id

interface GymDataSource {
    fun getAllSession(): GymResult<List<Session>>
    fun getExercise(id: Id): GymResult<List<Exercise>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getExerciseTypesBy(idMuscleGroup: Id): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllRoutines(): GymResult<List<Routine>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
    fun getBySession(id: Id): GymResult<List<SessionExercise>>
    fun persistSessionExercises(sessionExercises: List<SessionExercise>): GymResult<List<SessionExercise>>
    fun getLaunchApp(): GymResult<List<LaunchApp>>
    fun getSessionSetBySessionExercise(id: Id): GymResult<List<SessionSet>>
}