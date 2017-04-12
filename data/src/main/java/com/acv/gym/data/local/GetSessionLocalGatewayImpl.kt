package com.acv.gym.data.local


import com.acv.gym.data.SessionDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionLocalGateway
import com.acv.gym.domain.model.SessionExerciseModel
import org.funktionale.either.Disjunction

class GetSessionLocalGatewayImpl(val dataSource: SessionDataSource) : SessionLocalGateway {

    override fun obtain(): Disjunction<GenericExceptions, List<SessionExerciseModel>> {
        try{
            return Disjunction.right(dataSource.getAll())
        } catch (ex: Exception){
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Disjunction<GenericExceptions, List<SessionExerciseModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}