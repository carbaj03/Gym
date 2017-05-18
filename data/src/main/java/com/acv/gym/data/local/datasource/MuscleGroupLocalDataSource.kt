package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.MuscleGroupDataModel
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option


open class MuscleGroupLocalDataSource : DataSource<MuscleGroupDataModel> {
    override fun getAll() =
            Either.Right(
                    listOf(
                            MuscleGroupDataModel("1", "Pecho"),
                            MuscleGroupDataModel("2", "Espalda"),
                            MuscleGroupDataModel("3", "Pierna")
                    )
            )

    override fun getBy(command: Option<Command>): Either<GenericExceptions, List<MuscleGroupDataModel>> {
        TODO("not implemented")
    }

    override fun persist(data: List<MuscleGroupDataModel>): Either<GenericExceptions, List<MuscleGroupDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}