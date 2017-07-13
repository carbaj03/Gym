package com.acv.gym.data.db.realm.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import com.acv.gym.domain.model.session.*
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id
import kategory.Either

open class GymRealm : GymDataSource {
    override fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id): GymResult<List<Exercise>> {
        TODO("not implemented")
    }

    override fun getExerciseTypesBy(idMuscleGroup: Id): GymResult<List<ExerciseType>> {
        TODO("not implemented")
    }

    override fun getSessionSetBySessionExercise(id: SessionExerciseId): GymResult<List<Set>> {
        TODO("not implemented")
    }

    override fun getBySession(id: SessionId): GymResult<List<SessionExercise>> {
        TODO("not implemented")
    }

    override fun getAllSession(): GymResult<List<Session>> {
        TODO("not implemented")
    }

    override fun getExercise(id: ExerciseId): Either<GenericError, List<Exercise>> {
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

    override fun getAllSessionExercises(): Either<GenericError, List<SessionExercise>> {
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

    override fun persistSessionExercises(sessionExercises: List<SessionExercise>): Either<GenericError, List<SessionExercise>> {
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