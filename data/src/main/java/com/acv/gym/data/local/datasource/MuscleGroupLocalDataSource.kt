package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.MuscleGroupDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either


open class MuscleGroupLocalDataSource : DataSource<MuscleGroupDataModel> {
    override fun getAll() =
            Either.Right(
                    listOf(
                            MuscleGroupDataModel("1", "Pecho"),
                            MuscleGroupDataModel("2", "Espalda"),
                            MuscleGroupDataModel("3", "Pierna")
                    )
            )

    override fun persist(data: List<MuscleGroupDataModel>): Either<GenericExceptions, List<MuscleGroupDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}