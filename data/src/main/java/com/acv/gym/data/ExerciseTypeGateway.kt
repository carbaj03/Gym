package com.acv.gym.data

import com.acv.gym.data.db.cache.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.data.db.cache.model.map
import com.acv.gym.domain.ExerciseTypeGateway
import com.acv.gym.domain.usecase.Command
import katz.Id
import katz.Option

class ExerciseTypeGateway(
        val dataSource: ExerciseTypeLocalDataSource
) : ExerciseTypeGateway {
    override fun obtain(command: Option<Command>) = dataSource.getBy(Id("a")).map { it.map { it.map() } }
}

