package com.acv.gym.data

import com.acv.gym.data.db.cache.datasource.ExercisesLocalDataSource
import com.acv.gym.data.db.cache.model.map
import com.acv.gym.domain.ExerciseGateway
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class ExercisesGateway(
        val dataSource: ExercisesLocalDataSource
) : ExerciseGateway<Command, GenericExceptions, Exercise> {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }
}
