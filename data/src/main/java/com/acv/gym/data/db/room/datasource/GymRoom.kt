package com.acv.gym.data.db.room.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.*
import katz.Either
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
class GymRoom : GymDataSource {

    override fun getExercise(id: Id<String>): Either<GenericExceptions, List<Exercise>> =
            try {
                val all = RoomDB.instance.exerciseDao().getBy(id.value)
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericExceptions.ServerError())
            }

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
}