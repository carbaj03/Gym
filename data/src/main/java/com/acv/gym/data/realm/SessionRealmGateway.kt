package com.acv.gym.data.realm


import com.acv.gym.data.realm.datasource.SessionExerciseDataSource
import com.acv.gym.data.realm.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import katz.Either

class SessionLocalGateway(val dataSource: SessionExerciseDataSource) : SessionGateway {

    override fun obtain(input: Command): Either<GenericExceptions, List<SessionExercise>> {
        try {
            return Either.Right(dataSource.getAll().map { it.map() })
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(sessionExercises: List<SessionExercise>) =
        dataSource.persist(sessionExercises.map { it.map() }).map { it.map { it.map() } }

}
