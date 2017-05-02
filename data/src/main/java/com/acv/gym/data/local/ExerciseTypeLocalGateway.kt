package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExerciseTypeGateway
import com.acv.gym.domain.model.ExerciseTypeModel
import katz.Either

class ExerciseTypeLocalGateway(val dataSource: ExerciseTypeLocalDataSource) : ExerciseTypeGateway {
    override fun obtain(): Either<GenericExceptions, List<ExerciseTypeModel>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<ExerciseTypeModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
