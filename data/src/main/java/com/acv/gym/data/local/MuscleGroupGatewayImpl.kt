package com.acv.gym.data.local

import com.acv.gym.data.MuscleGroupDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.model.MuscleGroupModel
import org.funktionale.either.Disjunction

class MuscleGroupGatewayImpl(val dataSource: MuscleGroupDataSource) : MuscleGroupLocalGateway {
    override fun obtain(): Disjunction<GenericExceptions, List<MuscleGroupModel>> {
        try{
            return Disjunction.right(dataSource.getAll())
        } catch (ex: Exception){
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Disjunction<GenericExceptions, List<MuscleGroupModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}