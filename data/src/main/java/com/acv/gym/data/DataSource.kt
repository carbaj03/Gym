package com.acv.gym.data

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.session.SessionCommand
import katz.Either
import katz.Option

interface DataModel

//interface DataSource<T : DataModel> {
//    fun getAll(): Either<GenericExceptions, List<T>>
//    fun getBy(command: Option<Command>): Either<GenericExceptions, List<T>>
//    fun persist(data: List<T>): Either<GenericExceptions, List<T>>
//}