package com.acv.gym.domain

import com.acv.gym.domain.model.*
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.model.exercise.ExerciseId
import com.acv.gym.domain.model.exercise.ExerciseType
import com.acv.gym.domain.model.session.*
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id
import kategory.Either


interface SharedPreference {
    fun getLaunchApp(): Either<GenericError, List<LaunchApp>>
}

interface GymGateway {
    fun getExercise(id: ExerciseId): GymResult<List<Exercise>>
    fun getAllSesion(): GymResult<List<Session>>
    fun getSessionExercisesBy(id: SessionId): GymResult<List<SessionExercise>>
    fun getSessionSetBy(id: SessionExerciseId): GymResult<List<Set>>
    fun getAllExercises(): GymResult<List<Exercise>>
    fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id): GymResult<List<Exercise>>
    fun getAllExerciseTypes(): GymResult<List<ExerciseType>>
    fun getExerciseTypesBy(id: Id): GymResult<List<ExerciseType>>
    fun getAllMuscleGroups(): GymResult<List<MuscleGroup>>
    fun getAllSessionExercises(): GymResult<List<SessionExercise>>
    fun persistSessionExercise(sessionExercises: List<SessionExercise>): GymResult<List<SessionExercise>>
}