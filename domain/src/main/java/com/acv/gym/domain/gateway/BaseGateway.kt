package com.acv.gym.domain.gateway

import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import katz.Either

interface BaseGateway<out E, out S> {
    fun obtain(command: Command = EmptyCommand()): Either<E, List<S>>
    fun persist(): Either<E, List<S>>
}
