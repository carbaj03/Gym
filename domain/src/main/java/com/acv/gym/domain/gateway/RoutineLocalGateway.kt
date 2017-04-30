package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.RoutineModel
import katz.Either

interface RoutineLocalGateway {
    fun obtain(): Either<GenericExceptions, List<RoutineModel>>
    fun persist(): Either<GenericExceptions, List<RoutineModel>>
}
