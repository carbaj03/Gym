package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseTypeModel
import org.funktionale.either.Disjunction

interface ExerciseTypeGateway {
    fun obtain() : Disjunction<GenericExceptions, List<ExerciseTypeModel>>
    fun persist(): Disjunction<GenericExceptions, List<ExerciseTypeModel>>
}
