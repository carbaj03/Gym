package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.MuscleGroupLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import katz.Either

class MuscleGroupLocalGatewayImpl(val dataSource: MuscleGroupLocalDataSource) : MuscleGroupLocalGateway {
    override fun obtain(command: Command): Either<GenericExceptions, List<MuscleGroup>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<MuscleGroup>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}