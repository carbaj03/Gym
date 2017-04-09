package com.acv.gym.domain.usecase.routine


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.usecase.UseCase
import org.funktionale.either.Disjunction

open class GetRoutinesUseCase(val getRoutinesLocalGateway: RoutineLocalGateway)
    : UseCase<Any, List<RoutineModel>, GenericExceptions> {
    
    override fun execute(input: Any): Disjunction<GenericExceptions, List<RoutineModel>>
            =  getRoutinesLocalGateway.obtain()
}