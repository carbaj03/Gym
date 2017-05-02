package com.acv.gym.data.local


import com.acv.gym.data.local.datasource.RoutineLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.model.RoutineModel
import katz.Either

open class RoutineLocalGatewayImpl(val dataSource: RoutineLocalDataSource) : RoutineLocalGateway {

    override fun obtain(): Either<GenericExceptions, List<RoutineModel>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<RoutineModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}