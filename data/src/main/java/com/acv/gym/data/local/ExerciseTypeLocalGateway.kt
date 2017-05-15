package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExerciseTypeGateway
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Command
import katz.Either

class ExerciseTypeLocalGateway(val dataSource: ExerciseTypeLocalDataSource) : ExerciseTypeGateway {
    override fun persist(list: List<ExerciseType>): Either<GenericExceptions, List<ExerciseType>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun obtain(command: Command): Either<GenericExceptions, List<ExerciseType>> = dataSource.getAll().map { it }

        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<ExerciseType>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
