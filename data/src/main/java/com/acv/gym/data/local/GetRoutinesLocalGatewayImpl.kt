package com.acv.gym.data.local


import com.acv.gym.data.RoutinesDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.model.RoutineModel
import org.funktionale.either.Disjunction

class GetRoutinesLocalGatewayImpl(val dataSource: RoutinesDataSource) : RoutineLocalGateway {

    override fun obtain(): Disjunction<GenericExceptions, List<RoutineModel>> {
        try {
            return Disjunction.right(dataSource.getAll())
        } catch (ex: Exception) {
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Disjunction<GenericExceptions, List<RoutineModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}