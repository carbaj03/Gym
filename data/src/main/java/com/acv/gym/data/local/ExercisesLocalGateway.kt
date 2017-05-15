package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExercisesLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExercisesGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Command
import katz.Either

class ExercisesLocalGateway(val dataSource: ExercisesLocalDataSource) : ExercisesGateway {
    override fun obtain(command: Command): Either<GenericExceptions, List<Exercise>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<Exercise>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
