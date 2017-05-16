package com.acv.gym.domain.usecase

import katz.Either
import katz.Option

interface UseCase<in I, out R, out E> {
    fun execute(input: Option<I>): Either<E, R>
}