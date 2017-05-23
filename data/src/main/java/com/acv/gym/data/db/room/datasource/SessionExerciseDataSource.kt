package com.acv.gym.data.db.room.datasource

import com.acv.gym.data.db.SessionExerciseDb
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.SessionExerciseDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
class SessionExerciseDataSource : SessionExerciseDb<GenericExceptions.ServerError, SessionExerciseDataModel> {
    override fun getAll() =
            try {
                val all = RoomDB.instance.exerciseDao().getAll()
                Either.Right(all.map { it })
            } catch (ex: Exception) {
                Either.Left(GenericExceptions.ServerError())
            }


    override fun persist(sessions: List<SessionExerciseDataModel>) =
            try {
                RoomDB.instance.exerciseDao().insertAll(sessions)
                Either.Right(sessions)
            } catch (ex: Exception) {
                Either.Left(GenericExceptions.ServerError())
            }
}