package com.acv.gym.presentation.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.core.InteractorExecution
import com.acv.gym.presentation.core.InteractorInvoker
import org.funktionale.either.Disjunction


open class SplashPresenter(val checkSplashUseCase: CheckSplashUseCase,
                           val interactorInvokerImp: InteractorInvoker) : Presenter<SplashView>() {

    fun loadSplash() {
//        InteractorExecution(checkSplashUseCase).execute(interactorInvokerImp)
        InteractorExecution(checkSplashUseCase, Any())
                .result({ if (it.isFirstTime) view.showSplash() })
                .error({ manageExceptions(it) })
                .execute(interactorInvokerImp)
//        val closeEventsFuture = Future { checkSplashUseCase.execute(Any())}
//        closeEventsFuture.onComplete { renderFeedResult(it) }
    }

    private fun renderFeedResult(result: Disjunction<GenericExceptions, LaunchAppModel>): Any =
            when (result) {
                is Disjunction.Left -> manageExceptions(result.swap().get())
                is Disjunction.Right -> result.map { if (it.isFirstTime) view.showSplash() }
            }

    private fun manageExceptions(exceptions: GenericExceptions) =
            when (exceptions) {
                is GenericExceptions.NetworkError -> view.renderNetworkError()
                is GenericExceptions.ServerError -> view.renderServerError()
            }
}