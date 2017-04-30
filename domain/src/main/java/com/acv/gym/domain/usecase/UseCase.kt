package com.acv.gym.domain.usecase

import katz.Either

interface UseCase<in I, out R, out E> {
    fun execute(input: I): Either<E, R>
}