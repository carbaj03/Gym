package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.ExerciseTypeDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either


open class ExerciseTypeLocalDataSource : DataSource<ExerciseTypeDataModel> {
    override fun getAll(): Either<GenericExceptions, List<ExerciseTypeDataModel>> =
            Either.Right(
                    listOf(
                            ExerciseTypeDataModel("1", "Dumbell")
                            , ExerciseTypeDataModel("2", "Bar")
                            , ExerciseTypeDataModel("3", "Cable")
                            , ExerciseTypeDataModel("4", "Body Weight")
                            , ExerciseTypeDataModel("4", "Machine")
                    )
            )

    override fun persist(data: List<ExerciseTypeDataModel>): Either<GenericExceptions, List<ExerciseTypeDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}