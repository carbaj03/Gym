package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.model.RoutineModel
import org.funktionale.either.Disjunction

interface RoutineLocalGateway {
    fun obtain(): Disjunction<GenericExceptions, List<RoutineModel>>
    fun persist(): Disjunction<GenericExceptions, List<RoutineModel>>
}
