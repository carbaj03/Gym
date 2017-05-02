package com.acv.gym.data.local


import com.acv.gym.data.local.datasource.SessionExerciseLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionLocalGateway
import com.acv.gym.domain.model.SessionExerciseModel
import katz.Either

class SessionLocalGatewayImpl(val dataSource: SessionExerciseLocalDataSource) : SessionLocalGateway {

    override fun obtain(date: String): Either<GenericExceptions, List<SessionExerciseModel>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<SessionExerciseModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
