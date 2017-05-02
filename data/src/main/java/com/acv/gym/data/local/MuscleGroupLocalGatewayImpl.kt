package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.MuscleGroupLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.model.MuscleGroupModel
import katz.Either

class MuscleGroupLocalGatewayImpl(val dataSource: MuscleGroupLocalDataSource) : MuscleGroupLocalGateway {
    override fun obtain(): Either<GenericExceptions, List<MuscleGroupModel>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<MuscleGroupModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}