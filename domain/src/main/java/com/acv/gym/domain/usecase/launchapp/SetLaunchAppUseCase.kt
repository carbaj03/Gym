package com.acv.gym.domain.usecase.launchapp

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.UseCase
import org.funktionale.either.Disjunction

open class SetLaunchAppUseCase(val collectionsDataSource: LaunchAppLocalGateway)
    : UseCase<Any, LaunchAppModel, GenericExceptions> {
    override fun execute(input: Any): Disjunction<GenericExceptions, LaunchAppModel>
            =  collectionsDataSource.persistLaunchApp()
}
