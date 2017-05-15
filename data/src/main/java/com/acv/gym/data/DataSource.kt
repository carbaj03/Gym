package com.acv.gym.data

import com.acv.gym.domain.GenericExceptions
import katz.Either

interface DataSource<T : DataModel> {
    fun getAll(): Either<GenericExceptions, List<T>>
    fun persist(data: List<T>): Either<GenericExceptions, List<T>>
}
