package com.acv.gym.data.local


import com.acv.gym.data.local.datasource.RoutineLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

open class RoutineLocalGateway(
        val dataSource: RoutineLocalDataSource
) : GenericGateway<Routine> {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }

    override fun persist(list: List<Routine>): Either<GenericExceptions, List<Routine>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}