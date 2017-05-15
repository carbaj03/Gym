package com.acv.gym.data.local


import com.acv.gym.data.local.datasource.RoutineLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.RoutineGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command
import katz.Either

open class RoutineLocalGateway(val dataSource: RoutineLocalDataSource) : RoutineGateway {

    override fun obtain(command: Command): Either<GenericExceptions, List<Routine>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<Routine>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}