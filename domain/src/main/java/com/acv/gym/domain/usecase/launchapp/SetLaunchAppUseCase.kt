package com.acv.gym.domain.usecase.launchapp

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.UseCase

open class SetLaunchAppUseCase(val collectionsDataSource: LaunchAppGateway)
    : UseCase<Any, List<LaunchApp>, GenericExceptions> {
    override fun execute(input: Any) = collectionsDataSource.persist(listOf())
}
