package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseTypeModel
import katz.Either
import org.funktionale.either.Disjunction

interface ExerciseTypeGateway {
    fun obtain() : Either<GenericExceptions, List<ExerciseTypeModel>>
    fun persist(): Either<GenericExceptions, List<ExerciseTypeModel>>
}
