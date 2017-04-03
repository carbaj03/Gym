package com.acv.gym.presentation.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import org.funktionale.either.Disjunction


open class SplashPresenter(val checkSplashUseCase: CheckSplashUseCase,
                           val interactorInvokerImp: InteractorInvoker) : Presenter<SplashView>() {

    fun loadSplash() {
        InteractorExecution(checkSplashUseCase, Any())
                .result({ if (it.isFirstTime) view.showSplash() })
                .errorResult({ manageExceptions(it) })
                .execute(interactorInvokerImp)
    }

    private fun manageExceptions(exceptions: GenericExceptions) =
            when (exceptions) {
                is GenericExceptions.NetworkError -> view.renderNetworkError()
                is GenericExceptions.ServerError -> view.renderServerError()
            }
}