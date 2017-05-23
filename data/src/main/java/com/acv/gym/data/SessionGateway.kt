package com.acv.gym.data


import com.acv.gym.data.db.room.datasource.SessionExerciseDataSource
import com.acv.gym.data.db.room.model.map
import com.acv.gym.domain.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import katz.Option

class SessionGateway(
        val dataSource: SessionExerciseDataSource
) : SessionGateway {
    override fun obtain(command: Option<Command>) = dataSource.getAll().map { it.map { it.map() } }

    fun persist(list: List<SessionExercise>) = dataSource.persist(list.map { it.map() })
}
