package com.acv.gym.data.local


import com.acv.gym.data.local.datasource.SessionExerciseLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class SessionLocalGateway(
        val dataSource: SessionExerciseLocalDataSource
) : SessionGateway {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }

    override fun persist(list: List<SessionExercise>): Either<GenericExceptions, List<SessionExercise>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
