package com.acv.gym.domain.service.splash


import com.acv.gym.domain.SharedPreference
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.service.EmptyCommand
import com.acv.gym.domain.service.GymUseCase
import kategory.Option

open class CheckSplashUseCase(
        val gateway: SharedPreference
) : GymUseCase<EmptyCommand, List<LaunchApp>> {
    override fun execute(input: Option<EmptyCommand>) = gateway.getLaunchApp()
}