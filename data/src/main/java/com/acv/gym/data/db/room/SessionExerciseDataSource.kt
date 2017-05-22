package com.acv.gym.data.db.room

import com.acv.gym.data.db.DB
import com.acv.gym.data.db.SessionExerciseDb
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
class SessionExerciseDataSource: SessionExerciseDb<GenericExceptions.ServerError, SessionExerciseDataModel> {
    override fun persist(models: List<SessionExerciseDataModel>): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        RoomDB.instance.exerciseDao().getAll()
    }

    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}