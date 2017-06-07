package com.acv.gym.data.db.realm.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.realm.model.SessionExerciseDataModel
import com.acv.gym.data.db.realm.model.map
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import com.acv.gym.domain.usecase.Id
import io.realm.Realm
import katz.Either

open class GymRealm : GymDataSource {
    override fun getSessionSetBySessionExercise(id: Id): GymResult<List<SessionSet>> {
        TODO("not implemented")
    }

    override fun getBySession(id: Id): GymResult<List<SessionExercise>> {
        TODO("not implemented")
    }

    override fun getAllSession(): GymResult<List<Session>> {
        TODO("not implemented")
    }

    override fun getExercise(id: Id): Either<GenericError, List<Exercise>> {
        TODO("not implemented")
    }

    override fun getAllExercises(): Either<GenericError, List<Exercise>> {
        TODO("not implemented")
    }

    override fun getAllExerciseTypes(): Either<GenericError, List<ExerciseType>> {
        TODO("not implemented")
    }

    override fun getAllMuscleGroups(): Either<GenericError, List<MuscleGroup>> {
        TODO("not implemented")
    }

    override fun getAllRoutines(): Either<GenericError, List<Routine>> {
        TODO("not implemented")
    }

    override fun getAllSessionExercises() : Either<GenericError, List<SessionExercise>> {
        TODO("not implemented")
    }
//            with(Realm.getDefaultInstance()) {
//                try {
//                    val objects = where(SessionExerciseDataModel::class.java).findAll()
//                    return@with Either.Right(objects.map { it.map() })
//                } catch (ex: Exception) {
//                    return@with Either.Left(GenericError.ServerError)
//                } finally {
//                    close()
//                }
//            }

    override fun persistSessionExercises(sessionExercises: List<SessionExercise>) : Either<GenericError, List<SessionExercise>> {
        TODO("not implemented")
    }
//            with(Realm.getDefaultInstance()) {
//                try {
//                    beginTransaction()
//                    copyToRealmOrUpdate(sessionExercises.map { it.map() })
//                    commitTransaction()
//                    return@with Either.Right(sessionExercises)
//                } catch (ex: Exception) {
//                    isInTransaction.let { cancelTransaction() }
//                    return@with Either.Left(GenericError.ServerError)
//                } finally {
//                    close()
//                }
//            }

    override fun getLaunchApp(): Either<GenericError, List<LaunchApp>> {
        TODO("not implemented")
    }


}