package com.acv.gym.data


import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id

class GymGatewayImpl(
        val dataSource: GymDataSource
) : GymGateway {
    override fun getAllSesion() = dataSource.getAllSession()

    override fun getExercise(id: Id) = dataSource.getExercise(id)

    override fun getAllExercises() = dataSource.getAllExercises()

    override fun getAllExerciseTypes() = dataSource.getAllExerciseTypes()

    override fun getAllMuscleGroups() = dataSource.getAllMuscleGroups()

    override fun getAllRoutines() = dataSource.getAllRoutines()

    override fun getAllSessionExercises() = dataSource.getAllSessionExercises()

    override fun getSessionExercisesBy(id: Id) = dataSource.getBySession(id)

    override fun getSessionSetBy(id: Id) = dataSource.getSessionSetBySessionExercise(id)

    override fun persistSessionExercise(sessionExercises: List<SessionExercise>)
            = dataSource.persistSessionExercises(sessionExercises)
}
