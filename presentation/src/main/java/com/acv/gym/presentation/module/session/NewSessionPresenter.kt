package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.NewSessionCommand
import com.acv.gym.domain.usecase.SessionCommand
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.domain.usecase.session.NewSessionExerciseUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option


open class NewSessionPresenter(
        view: NewSessionView,
        val useCase: NewSessionExerciseUseCase,
        val invoker: InteractorInvoker
) : Presenter<NewSessionView>(view) {

    fun persist(command: Option<NewSessionCommand>) =
            InteractorExecution(
                    interactor = useCase,
                    params = command,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(sessionExercises: List<SessionExercise>) = view.showSuccess()

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(it: SessionExercise) {
        TODO("not implemented")
    }

}