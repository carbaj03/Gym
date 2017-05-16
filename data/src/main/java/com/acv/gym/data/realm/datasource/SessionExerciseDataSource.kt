package com.acv.gym.data.realm.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.realm.model.SessionExerciseDataModel
import com.acv.gym.domain.GenericExceptions
import io.realm.Realm
import katz.Either


open class SessionExerciseDataSource : DataSource<SessionExerciseDataModel> {
    override fun getAll(): Either<GenericExceptions, List<SessionExerciseDataModel>> =
            with(Realm.getDefaultInstance()) {
                try {
                    val objects = where(SessionExerciseDataModel::class.java).findAll()
                    return@with Either.Right(objects.map { it })
                } catch (ex: Exception) {
                    return@with Either.Left(GenericExceptions.NetworkError())
                } finally {
                    close()
                }
            }

    override fun persist(model: List<SessionExerciseDataModel>) =
            with(Realm.getDefaultInstance()) {
                try {
                    beginTransaction()
                    copyToRealmOrUpdate(model)
                    commitTransaction()
                    return@with Either.Right(model)
                } catch (ex: Exception) {
                    isInTransaction.let { cancelTransaction() }
                    return@with Either.Left(GenericExceptions.NetworkError())
                } finally {
                    close()
                }
            }
}