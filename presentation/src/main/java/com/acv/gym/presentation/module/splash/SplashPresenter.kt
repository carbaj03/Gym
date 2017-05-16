package com.acv.gym.presentation.module.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class SplashPresenter(view: SplashView,
                           val checkSplashUseCase: CheckSplashUseCase,
                           val interactorInvokerImp: InteractorInvoker) : Presenter<SplashView>(view) {

    fun loadSplash() {
        InteractorExecution(checkSplashUseCase)
                .result { happyCase(it[0]) }
                .errorResult { manageExceptions(it) }
                .execute(interactorInvokerImp)
    }

    private fun happyCase(launchAppModel: LaunchApp) =
            when (launchAppModel.isFirstTime) {
                true -> view.show(emptyList())
                false -> view.showNetworkError()
            }


    private fun manageExceptions(exceptions: GenericExceptions) =
            when (exceptions) {
                is GenericExceptions.NetworkError -> view.showNetworkError()
                is GenericExceptions.ServerError -> view.showServerError()
            }
}