package com.acv.gym.data.local.datasource

import com.acv.gym.data.DataSource
import com.acv.gym.data.local.model.RoutineDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either


open class RoutineLocalDataSource : DataSource<RoutineDataModel> {
    override fun getAll() =
            Either.Right(
                    listOf(
                            RoutineDataModel("1", "Full Body", ""),
                            RoutineDataModel("2", "Torso/Pierna", ""),
                            RoutineDataModel("3", "Push/Pull/Leg", "")
                    )
            )

    override fun persist(data: List<RoutineDataModel>): Either<GenericExceptions, List<RoutineDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}