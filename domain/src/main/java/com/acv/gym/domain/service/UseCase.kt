package com.acv.gym.domain.service

import com.acv.gym.domain.GenericError
import kategory.Either
import kategory.Option

typealias GymUseCase<I, R> = UseCase<I, R, GenericError>

interface UseCase<in I : Command, out R, out E : GenericError> {
    fun execute(input: Option<I>): Either<E, R>
}