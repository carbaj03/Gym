package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.SessionExerciseDataModel
import com.acv.gym.data.local.model.SessionSetDataModel
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option


open class SessionExerciseLocalDataSource : DataSource<SessionExerciseDataModel> {
    override fun getAll(): Either<GenericExceptions, List<SessionExerciseDataModel>> =
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

    override fun getBy(command: Option<Command>): Either<GenericExceptions, List<SessionExerciseDataModel>> {
        TODO("not implemented")
    }


    override fun persist(data: List<SessionExerciseDataModel>): Either<GenericExceptions, List<SessionExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}