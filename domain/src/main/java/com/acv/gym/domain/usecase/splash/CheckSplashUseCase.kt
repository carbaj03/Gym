package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.SharedPreference
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.GymUseCase
import katz.Option

open class CheckSplashUseCase(
        val gateway: SharedPreference
) : GymUseCase<EmptyCommand, List<LaunchApp>> {
    override fun execute(input: Option<EmptyCommand>) = gateway.getLaunchApp()
}