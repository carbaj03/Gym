package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.SharedPreference
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class CheckSplashUseCase(
        val gateway: SharedPreference
) : UseCase<Command, List<LaunchApp>, GenericError> {
    override fun execute(input: Option<Command>) = gateway.getLaunchApp()
}