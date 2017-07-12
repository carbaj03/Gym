package com.acv.gym.domain.service.routine


import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.service.Command
import com.acv.gym.domain.service.GymUseCase
import kategory.Option

open class GetRoutineUseCase(
        val gateway: GymGateway
) : GymUseCase<Command, List<Routine>> {
    override fun execute(input: Option<Command>) = gateway.getAllRoutines()
}