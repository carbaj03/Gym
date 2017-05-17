package com.acv.gym.data.realm


import com.acv.gym.data.realm.datasource.SessionExerciseDataSource
import com.acv.gym.data.realm.model.map
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command
import katz.Option

class SessionRealmGateway(
        val dataSource: SessionExerciseDataSource
) : SessionGateway {
    override fun obtain(command: Option<Command>) =
            dataSource.getAll().map { it.map { it.map() } }

    override fun persist(sessionExercises: List<SessionExercise>) =
            dataSource.persist(sessionExercises.map { it.map() }).map { it.map { it.map() } }
}
