package com.acv.gym.domain.usecase.routine


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.RoutineGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class GetRoutineUseCase(
        val gateway: RoutineGateway
) : UseCase<Command, List<Routine>, GenericExceptions> {
    override fun execute(input: Option<Command>) = gateway.obtain(input)
}