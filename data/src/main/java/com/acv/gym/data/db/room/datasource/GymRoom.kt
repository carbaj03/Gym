package com.acv.gym.data.db.room.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.map
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.model.SessionExercise
import katz.Either
import katz.Id

class GymRoom : GymDataSource {
    override fun getAllSession() =
            try {
                val all = RoomDB.instance.sessionDao().getAll()
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun getExercise(id: Id<String>) =
            try {
                val all = RoomDB.instance.exerciseDao().getBy(id.value)
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun getAllExercises() =
            try {
                val all = RoomDB.instance.exerciseDao().getAll()
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun getAllExerciseTypes() =
            try {
                val all = RoomDB.instance.exerciseTypeDao().getAll()
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }


    override fun getAllMuscleGroups() =
            try {
                val all = RoomDB.instance.muscleGroupDao().getAll()
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun getAllRoutines(): Either<GenericError, List<Routine>> = TODO("not implemented")

    override fun getAllSessionExercises() =
            try {
                val all = RoomDB.instance.sessionExerciseDao().getAll()
                Either.Right(all.map { it.map() })
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun persistSessionExercises(sessionExercises: List<SessionExercise>) =
            try {
                RoomDB.instance.sessionExerciseDao().insertAll(sessionExercises.map { it.map() })
                Either.Right(sessionExercises)
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }

    override fun getLaunchApp(): Either<GenericError, List<LaunchApp>> = TODO("not implemented")
}