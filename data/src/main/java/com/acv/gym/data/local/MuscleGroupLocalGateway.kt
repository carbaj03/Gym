package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.MuscleGroupLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class MuscleGroupLocalGateway(
        val dataSource: MuscleGroupLocalDataSource
) : GenericGateway<MuscleGroup> {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }

    override fun persist(list: List<MuscleGroup>): Either<GenericExceptions, List<MuscleGroup>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}