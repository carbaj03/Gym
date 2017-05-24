package com.acv.gym.presentation.module.splash

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class SplashPresenter(
        view: SplashView,
        val useCase: CheckSplashUseCase,
        val invoker: InteractorInvoker
) : Presenter<SplashView>(view) {

    fun loadSplash() =
            InteractorExecution(
                    interactor = useCase,
                    result = { happyCase(it[0]) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(launchAppModel: LaunchApp) = when (launchAppModel.isFirstTime) {
        true -> view.show(emptyList())
        false -> view.showNetworkError()
    }


    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }
}