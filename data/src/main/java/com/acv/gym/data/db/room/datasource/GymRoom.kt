package com.acv.gym.data.db.room.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.map
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.service.Id
import kategory.Either

class GymRoom : GymDataSource {
    override fun getAllSession() = try {
        val all = RoomDB.instance.sessionDao().getAll()
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getExercise(id: Id) = try {
        val all = RoomDB.instance.exerciseDao().getByExerciseType(id.value)
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getAllExercises() = try {
        val all = RoomDB.instance.exerciseDao().getAll()
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id) = try {
        val all = RoomDB.instance.exerciseDao().getBy(idMuscleGroup.value, idExerciseType.value)
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getAllExerciseTypes() = try {
        val all = RoomDB.instance.exerciseTypeDao().getAll()
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getExerciseTypesBy(idMuscleGroup: Id) = try {
        val all = RoomDB.instance.exerciseTypeDao().getBy(idMuscleGroup.value)
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getAllMuscleGroups() = try {
        val all = RoomDB.instance.muscleGroupDao().getExist()
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getAllRoutines(): Either<GenericError, List<Routine>> = TODO("not implemented")

    override fun getAllSessionExercises() = try {
        val all = RoomDB.instance.sessionExerciseDao().getAll()
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getBySession(id: Id) = try {
        val all = RoomDB.instance.sessionExerciseDao().getBySession(id.value)
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getSessionSetBySessionExercise(id: Id) = try {
        val all = RoomDB.instance.sessionSetDao().getBySessionExercise(id.value)
        Either.Right(all.map { it.map() })
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun persistSessionExercises(sessionExercises: List<SessionExercise>) = try {
        RoomDB.instance.sessionExerciseDao().insertAll(sessionExercises.map { it.map() })
        sessionExercises.map { RoomDB.instance.sessionSetDao().insertAll(it.sets.map { it.map() }) }
        Either.Right(sessionExercises)
    } catch (ex: Exception) {
        Either.Left(GenericError.ServerError)
    }

    override fun getLaunchApp(): Either<GenericError, List<LaunchApp>> = TODO("not implemented")
}