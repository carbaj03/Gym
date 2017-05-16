package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExercisesLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class ExercisesLocalGateway(
        val dataSource: ExercisesLocalDataSource
) : GenericGateway<Exercise> {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }

    override fun persist(list: List<Exercise>): Either<GenericExceptions, List<Exercise>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
