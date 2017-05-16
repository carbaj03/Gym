package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.UseCase
import katz.Option

open class CheckSplashUseCase(
        val collectionsDataSource: LaunchAppGateway
) : UseCase<Command, List<LaunchApp>, GenericExceptions> {
    override fun execute(input: Option<Command>) = collectionsDataSource.obtain(input)
}