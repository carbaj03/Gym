package com.acv.gym.domain.usecase.routine


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase

open class GetRoutineUseCase(val getRoutinesLocalGateway: RoutineLocalGateway)
    : UseCase<Command, List<Routine>, GenericExceptions> {

    override fun execute(input: Command) = getRoutinesLocalGateway.obtain(input)
}