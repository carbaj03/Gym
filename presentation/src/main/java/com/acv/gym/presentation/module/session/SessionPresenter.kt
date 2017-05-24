package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.domain.usecase.session.SessionCommand
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option


open class SessionPresenter(
        view: SessionView,
        val useCase: GetSessionExercisesUseCase,
        val invoker: InteractorInvoker
) : Presenter<SessionView>(view) {
    fun loadSessions(command: Option<SessionCommand>) =
            InteractorExecution(
                    interactor = useCase,
                    params = command,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(sessionExercises: List<SessionExercise>) = view.show(sessionExercises)

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(sessionExercises: SessionExercise) {
    }
}