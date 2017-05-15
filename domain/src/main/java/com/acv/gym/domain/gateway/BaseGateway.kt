package com.acv.gym.domain.gateway

import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import katz.Either
import katz.Option

interface BaseGateway<in I : Command, out E, S> {
    fun obtain(command: Option<I>): Either<E, List<S>>
    fun persist(list: List<S>): Either<E, List<S>>
}