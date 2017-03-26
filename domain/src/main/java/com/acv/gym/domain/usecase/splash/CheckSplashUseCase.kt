package com.acv.gym.domain.usecase.splash


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.UseCase
import org.funktionale.either.Disjunction

class CheckSplashUseCase(val collectionsDataSource: LaunchAppLocalGateway) : UseCase<Any, LaunchAppModel, GenericExceptions> {

    override fun execute(input: Any): Disjunction<GenericExceptions, LaunchAppModel>
            = collectionsDataSource.obtainLaunchApp()
}
