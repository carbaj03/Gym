package com.acv.gym.data.db

import com.acv.gym.data.DataModel
import com.acv.gym.domain.GenericExceptions
import katz.Either
import katz.Id

/**
 * Created by alejandro on 21/05/2017.
 */
interface MuscleGroupDb<out E: GenericExceptions, S: DataModel> {
    fun persist(sessions: List<S>): Either<E, List<S>>
    fun getAll(): Either<E, List<S>>
    fun getBy(id: Id<String>): Either<E, List<S>>
}