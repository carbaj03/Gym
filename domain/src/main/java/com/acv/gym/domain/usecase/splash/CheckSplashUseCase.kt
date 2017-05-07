package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase

open class CheckSplashUseCase(val collectionsDataSource: LaunchAppLocalGateway)
    : UseCase<Command, List<LaunchApp>, GenericExceptions> {
    override fun execute(input: Command) = collectionsDataSource.obtain(input)
}