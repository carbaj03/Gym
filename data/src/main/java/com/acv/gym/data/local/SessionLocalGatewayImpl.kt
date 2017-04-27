package com.acv.gym.data.local


import com.acv.gym.data.DataSource
import com.acv.gym.data.local.datasource.SessionExerciseLocalDataSource
import com.acv.gym.data.model.SessionExerciseDataModel
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionLocalGateway
import com.acv.gym.domain.model.SessionExerciseModel
import org.funktionale.either.Disjunction

class SessionLocalGatewayImpl(val dataSource: SessionExerciseLocalDataSource): SessionLocalGateway {

    override fun obtain(date: String): Disjunction<GenericExceptions, List<SessionExerciseModel>> {
        try {
            return Disjunction.right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Disjunction<GenericExceptions, List<SessionExerciseModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
