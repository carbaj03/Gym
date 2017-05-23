package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.SessionExerciseDb
import com.acv.gym.data.db.cache.model.SessionExerciseDataModel
import com.acv.gym.data.db.cache.model.SessionSetDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id


open class SessionExerciseLocalDataSource : SessionExerciseDb<GenericExceptions.ServerError, SessionExerciseDataModel> {
    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        TODO("not implemented")
    }

    override fun getAll(): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> =
            Either.Right(
                    listOf(
                            SessionExerciseDataModel(
                                    "1",
                                    "Press Banca Plano",
                                    listOf(
                                            SessionSetDataModel("1", 20f, 10, ""),
                                            SessionSetDataModel("2", 20f, 10, "")
                                    ),
                                    "1"
                            ),
                            SessionExerciseDataModel(
                                    "2",
                                    "Militar DB",
                                    listOf(
                                            SessionSetDataModel("1", 20f, 10, ""),
                                            SessionSetDataModel("2", 20f, 10, "")
                                    ),
                                    "1"
                            )
                            ,
                            SessionExerciseDataModel(
                                    "3",
                                    "Press Inclinado DB",
                                    listOf(
                                            SessionSetDataModel("1", 20f, 10, ""),
                                            SessionSetDataModel("2", 20f, 10, "")
                                    ),
                                    "1")
                    )
            )

    override fun persist(data: List<SessionExerciseDataModel>): Either<GenericExceptions.ServerError, List<SessionExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}