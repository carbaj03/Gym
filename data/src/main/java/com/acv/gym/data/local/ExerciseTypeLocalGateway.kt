package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.data.local.model.map
import com.acv.gym.domain.ExerciseTypeGateway
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class ExerciseTypeLocalGateway(
        val dataSource: ExerciseTypeLocalDataSource
) : ExerciseTypeGateway {
    override fun obtain(command: Option<Command>) = dataSource.getBy(command).map { it.map { it.map() } }

    override fun persist(list: List<ExerciseType>): Either<GenericExceptions, List<ExerciseType>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
