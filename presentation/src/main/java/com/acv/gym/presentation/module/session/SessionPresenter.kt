package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.session.GetSessionUseCase
import com.acv.gym.domain.usecase.session.SessionCommand
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option


open class SessionPresenter(
        view: SessionView
        , val getSessionUseCase: GetSessionUseCase
        , val invoker: InteractorInvoker
) : Presenter<SessionView>(view) {
    fun loadSessions(command: Option<SessionCommand>) =
            InteractorExecution(getSessionUseCase, command)
                    .result { happyCase(it) }
                    .errorResult { manageExceptions(it) }
                    .execute(invoker)

    private fun happyCase(sessionExercises: List<SessionExercise>) = view.show(sessionExercises)

    private fun manageExceptions(exceptions: GenericExceptions) = when (exceptions) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }

    fun checkExercise(sessionExercises: SessionExercise) {
    }
}