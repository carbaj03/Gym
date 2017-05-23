package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.MuscleGroupDb
import com.acv.gym.data.db.cache.model.MuscleGroupDataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id


open class MuscleGroupLocalDataSource : MuscleGroupDb<GenericExceptions.ServerError, MuscleGroupDataModel> {
    override fun getBy(id: Id<String>): Either<GenericExceptions.ServerError, List<MuscleGroupDataModel>> {
        TODO("not implemented")
    }

    override fun getAll() =
            Either.Right(
                    listOf(
                            MuscleGroupDataModel("1", "Pecho"),
                            MuscleGroupDataModel("2", "Espalda"),
                            MuscleGroupDataModel("3", "Pierna")
                    )
            )

    override fun persist(data: List<MuscleGroupDataModel>): Either<GenericExceptions.ServerError, List<MuscleGroupDataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}