package com.acv.gym.domain.gateway

import com.acv.gym.data.DataSource
import com.acv.gym.domain.GenericExceptions
import org.funktionale.either.Disjunction


class Gateway<R>(val dataSource: DataSource<R>) {
    fun obtain(f: () -> List<R>): Disjunction<GenericExceptions, List<R>> {
        try {
            return Disjunction.right(dataSource.getAll())
        } catch (ex: Exception) {
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    fun persist(): Disjunction<GenericExceptions, List<R>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}