package com.acv.gym.domain.usecase

import org.funktionale.either.Disjunction

interface UseCase<in I, out R, out E> {

    fun execute(input: I): Disjunction<E, R>
}