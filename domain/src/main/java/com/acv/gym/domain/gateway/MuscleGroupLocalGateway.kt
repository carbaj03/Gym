package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.MuscleGroupModel
import katz.Either

interface MuscleGroupLocalGateway {
    fun obtain(): Either<GenericExceptions, List<MuscleGroupModel>>
    fun persist(): Either<GenericExceptions, List<MuscleGroupModel>>
}