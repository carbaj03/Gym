package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.ExercisesDb
import com.acv.gym.data.db.cache.model.ExerciseDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id


open class ExercisesLocalDataSource : ExercisesDb<GenericExceptions.ServerError, ExerciseDataModel> {
    override fun getAll() =
            Either.Right(
                    listOf(
                            ExerciseDataModel("1", "Curl")
                            , ExerciseDataModel("2", "Press Banca Plano")
                            , ExerciseDataModel("3", "Dominadas")
                            , ExerciseDataModel("4", "Dips")
                            , ExerciseDataModel("5", "Squat")
                    )
            )

    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<ExerciseDataModel>> {
        TODO("not implemented")
    }

    override fun persist(data: List<ExerciseDataModel>): Either<GenericExceptions.ServerError, List<ExerciseDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}