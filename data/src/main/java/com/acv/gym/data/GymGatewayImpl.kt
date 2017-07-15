package com.acv.gym.data


import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.exercise.ExerciseId
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.model.session.SessionId
import com.acv.gym.domain.service.Id

class GymGatewayImpl(
        val dataSource: GymDataSource
) : GymGateway {
    override fun getAllSesion() = dataSource.getAllSession()

    override fun getExercise(id: ExerciseId) = dataSource.getExercise(id)

    override fun getAllExercises() = dataSource.getAllExercises()

    override fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id)
            = dataSource.getExercisesBy(idMuscleGroup, idExerciseType)

    override fun getAllExerciseTypes() = dataSource.getAllExerciseTypes()

    override fun getExerciseTypesBy(id: Id) = dataSource.getExerciseTypesBy(id)

    override fun getAllMuscleGroups() = dataSource.getAllMuscleGroups()

    override fun getAllSessionExercises() = dataSource.getAllSessionExercises()

    override fun getSessionExercisesBy(id: SessionId) = dataSource.getBySession(id)

    override fun getSessionSetBy(id: SessionExerciseId) = dataSource.getSessionSetBySessionExercise(id)

    override fun persistSessionExercise(sessionExercises: List<SessionExercise>)
            = dataSource.persistSessionExercises(sessionExercises)
}
