package com.acv.gym.data

import com.acv.gym.data.db.cache.datasource.MuscleGroupLocalDataSource
import com.acv.gym.data.db.cache.model.MuscleGroupDataModel
import com.acv.gym.data.db.cache.model.map
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.MuscleGroupGateway
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class MuscleGroupGateway(
        val dataSource: MuscleGroupLocalDataSource
) : MuscleGroupGateway {
     override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }
}