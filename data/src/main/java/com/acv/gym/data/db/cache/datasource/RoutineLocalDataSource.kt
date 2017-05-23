package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.RoutineDb
import com.acv.gym.data.db.cache.model.RoutineDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id


open class RoutineLocalDataSource : RoutineDb<GenericExceptions.ServerError, RoutineDataModel> {
    override fun getAll() =
            Either.Right(
                    listOf(
                            RoutineDataModel("1", "Full Body", ""),
                            RoutineDataModel("2", "Torso/Pierna", ""),
                            RoutineDataModel("3", "Push/Pull/Leg", "")
                    )
            )

    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<RoutineDataModel>> {
        TODO("not implemented")
    }

    override fun persist(data: List<RoutineDataModel>): Either<GenericExceptions.ServerError, List<RoutineDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}