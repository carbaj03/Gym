package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.ExerciseDataModel
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option


open class ExercisesLocalDataSource : DataSource<ExerciseDataModel> {
    override fun getAll(): Either<GenericExceptions, List<ExerciseDataModel>> =
            Either.Right(
                    listOf(
                            ExerciseDataModel("1", "Curl")
                            , ExerciseDataModel("2", "Press Banca Plano")
                            , ExerciseDataModel("3", "Dominadas")
                            , ExerciseDataModel("4", "Dips")
                            , ExerciseDataModel("5", "Squat")
                    )
            )

    override fun getBy(command: Option<Command>): Either<GenericExceptions, List<ExerciseDataModel>> {
        TODO("not implemented")
    }

    override fun persist(data: List<ExerciseDataModel>): Either<GenericExceptions, List<ExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}