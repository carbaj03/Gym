package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.MuscleGroupModel
import org.funktionale.either.Disjunction

interface MuscleGroupLocalGateway {
    fun obtain(): Disjunction<GenericExceptions, List<MuscleGroupModel>>
    fun persist(): Disjunction<GenericExceptions, List<MuscleGroupModel>>
}