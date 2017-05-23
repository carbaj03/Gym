package com.acv.gym.data


import com.acv.gym.data.db.cache.datasource.RoutineLocalDataSource
import com.acv.gym.data.db.cache.model.map
import com.acv.gym.domain.RoutineGateway
import com.acv.gym.domain.usecase.Command
import katz.Option

open class RoutineGateway(
        val dataSource: RoutineLocalDataSource
) : RoutineGateway {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }
}