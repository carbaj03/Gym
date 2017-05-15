package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase

open class CheckSplashUseCase(val collectionsDataSource: LaunchAppGateway)
    : UseCase<Command, List<LaunchApp>, GenericExceptions> {
    override fun execute(input: Command) = collectionsDataSource.obtain(input)
}