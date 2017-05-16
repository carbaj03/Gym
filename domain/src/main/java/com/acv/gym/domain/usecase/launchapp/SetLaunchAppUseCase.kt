package com.acv.gym.domain.usecase.launchapp

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class SetLaunchAppUseCase(
        val gateway: LaunchAppGateway
) : UseCase<Command, List<LaunchApp>, GenericExceptions> {
    override fun execute(input: Option<Command>) = gateway.persist(listOf())
}
