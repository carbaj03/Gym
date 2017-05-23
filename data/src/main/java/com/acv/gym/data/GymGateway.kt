package com.acv.gym.data


import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.*
import katz.Either
import katz.Id

class GymGatewayImpl(
        val dataSource: GymDataSource
) : GymGateway {
    override fun getExercise(id: Id<String>) = dataSource.getExercise(id)

    override fun getAllExercises(): Either<GenericExceptions, List<Exercise>> {
        TODO("not implemented")
    }

    override fun getAllMuscleGroups(): Either<GenericExceptions, List<MuscleGroup>> {
        TODO("not implemented")
    }

    override fun getAllRoutines(): Either<GenericExceptions, List<Routine>> {
        TODO("not implemented")
    }

    override fun getAllSessionExercises(): Either<GenericExceptions, List<SessionExercise>> {
        TODO("not implemented")
    }

    override fun getLaunchApp(): Either<GenericExceptions, List<LaunchApp>> {
        TODO("not implemented")
    }

//    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }
//
//    fun persist(list: List<SessionExercise>) = dataSource.persist(list.map { it.map() })
}
