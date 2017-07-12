package com.acv.gym.data.db

import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import com.acv.gym.domain.model.session.*
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id

interface GymDataSource {
    fun getAllSession(): GymResult<List<Session>>
    fun getExercise(id: Id): GymResult<List<Exercise>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getExerciseTypesBy(idMuscleGroup: Id): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
    fun getBySession(id: SessionId): GymResult<List<SessionExercise>>
    fun persistSessionExercises(sessionExercises: List<SessionExercise>): GymResult<List<SessionExercise>>
    fun getLaunchApp(): GymResult<List<LaunchApp>>
    fun getSessionSetBySessionExercise(id: SessionExerciseId): GymResult<List<Set>>
}