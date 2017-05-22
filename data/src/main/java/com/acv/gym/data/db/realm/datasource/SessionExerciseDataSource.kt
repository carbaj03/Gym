package com.acv.gym.data.db.realm.datasource

import com.acv.gym.data.db.DB
import com.acv.gym.data.db.realm.model.SessionExerciseDataModel
import com.acv.gym.domain.GenericExceptions
import io.realm.Realm
import katz.Either
import katz.Id

open class SessionExerciseDataSource : DB<GenericExceptions.ServerError, SessionExerciseDataModel> {
    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll() =
            with(Realm.getDefaultInstance()) {
                try {
                    val objects = where(SessionExerciseDataModel::class.java).findAll()
                    return@with Either.Right(objects.map { it })
                } catch (ex: Exception) {
                    return@with Either.Left(GenericExceptions.ServerError())
                } finally {
                    close()
                }
            }

    override fun persist(models: List<SessionExerciseDataModel>) =
            with(Realm.getDefaultInstance()) {
                try {
                    beginTransaction()
                    copyToRealmOrUpdate(models)
                    commitTransaction()
                    return@with Either.Right(models)
                } catch (ex: Exception) {
                    isInTransaction.let { cancelTransaction() }
                    return@with Either.Left(GenericExceptions.ServerError())
                } finally {
                    close()
                }
            }
}

//inline fun <T: RealmModel> Realm.i(model: List<T>): Either<GenericExceptions, List<T>> {
//        try {
//            beginTransaction()
//            copyToRealmOrUpdate(model)
//            commitTransaction()
//            return Either.Right(model)
//        } catch (ex: Exception) {
//            isInTransaction.let { cancelTransaction() }
//            return Either.Left(GenericExceptions.NetworkError())
//        } finally {
//            close()
//        }
//
//}