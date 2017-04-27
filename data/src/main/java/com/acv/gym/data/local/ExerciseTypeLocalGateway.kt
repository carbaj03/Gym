package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.data.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.ExerciseTypeGateway
import com.acv.gym.domain.model.ExerciseTypeModel
import org.funktionale.either.Disjunction

class ExerciseTypeLocalGateway(val dataSource: ExerciseTypeLocalDataSource) : ExerciseTypeGateway {
    override fun obtain(): Disjunction<GenericExceptions, List<ExerciseTypeModel>> {
        try {
            return Disjunction.right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Disjunction<GenericExceptions, List<ExerciseTypeModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
