package com.acv.gym.presentation.module.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class SplashPresenter(view: SplashView,
                           val checkSplashUseCase: CheckSplashUseCase,
                           val interactorInvokerImp: InteractorInvoker) : Presenter<SplashView>(view) {

    fun loadSplash(command: Command = EmptyCommand()) {
        InteractorExecution(checkSplashUseCase, command)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it) }
                .execute(interactorInvokerImp)
    }

    private fun happyCase(launchAppModel: LaunchAppModel) : Unit {
        if (launchAppModel.isFirstTime) {
            view.showSplash()
        }
    }

    private fun manageExceptions(exceptions: GenericExceptions) =
            when (exceptions) {
                is GenericExceptions.NetworkError -> view.renderNetworkError()
                is GenericExceptions.ServerError -> view.renderServerError()
            }
}