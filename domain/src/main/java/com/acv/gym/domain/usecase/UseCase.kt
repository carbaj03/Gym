package com.acv.gym.domain.usecase

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Model
import katz.Either
import katz.Option

interface UseCase<in I: Command, out R: List<Model>, out E: GenericExceptions> {
    fun execute(input: Option<I>): Either<E, R>
}