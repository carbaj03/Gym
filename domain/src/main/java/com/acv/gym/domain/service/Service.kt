package com.acv.gym.domain.service

import com.acv.gym.domain.GenericError
import kategory.Either
import kategory.Option

typealias GymUseCase<I, R> = Service<I, R, GenericError>

interface Service<in I : Request, out R, out E : GenericError> {
    fun execute(input: Option<I>): Either<E, R>
}