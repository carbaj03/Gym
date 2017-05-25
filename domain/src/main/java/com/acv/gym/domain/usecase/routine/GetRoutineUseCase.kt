package com.acv.gym.domain.usecase.routine


import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.GymUseCase
import katz.Option

open class GetRoutineUseCase(
        val gateway: GymGateway
) : GymUseCase<Command, List<Routine>> {
    override fun execute(input: Option<Command>) = gateway.getAllRoutines()
}