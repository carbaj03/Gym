package com.acv.gym.domain.usecase

import com.acv.gym.domain.GenericError
import katz.Either
import katz.Option

typealias GymUseCase<I, R> = UseCase<I, R, GenericError>

interface UseCase<in I : Command, out R, out E : GenericError> {
    fun execute(input: Option<I>): Either<E, R>
}