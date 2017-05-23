package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.ExerciseTypeDb
import com.acv.gym.data.db.cache.model.ExerciseTypeDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id


open class ExerciseTypeLocalDataSource : ExerciseTypeDb<GenericExceptions.ServerError, ExerciseTypeDataModel> {
    override fun getBy(id: Id<String>) =
            Either.Right(
                    listOf(
                            ExerciseTypeDataModel("1", "Dumbell")
                    )
            )

    override fun getAll(): Either<GenericExceptions.ServerError, List<ExerciseTypeDataModel>> =
            Either.Right(
                    listOf(
                            ExerciseTypeDataModel("1", "Dumbell")
                            , ExerciseTypeDataModel("2", "Bar")
                            , ExerciseTypeDataModel("3", "Cable")
                            , ExerciseTypeDataModel("4", "Body Weight")
                            , ExerciseTypeDataModel("4", "Machine")
                    )
            )

    override fun persist(data: List<ExerciseTypeDataModel>): Either<GenericExceptions.ServerError, List<ExerciseTypeDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}