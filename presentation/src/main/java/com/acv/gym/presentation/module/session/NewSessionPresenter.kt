package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.NewSessionCommand
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

    private var session: SessionExercise = SessionExercise()
    private var sets: List<SessionSet> = listOf()
    private var sessionSet: SessionSet = SessionSet()

    fun persist() =
            InteractorExecution(
                    interactor = useCase,
                    params = Option(NewSessionCommand(listOf(session))),
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(sessionExercises: List<SessionExercise>) = view.showSuccess()

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(it: Id) {
        session = session.copy(exercise = it.value)
    }

    fun checkWeight(num: Float) {
        sessionSet = sessionSet.copy(weight = num)
    }

    fun checkRep(num: Int) {
        sessionSet = sessionSet.copy(reps = num)
        sets = sets.plus(sessionSet)
        session = session.copy(sets = sets)
    }

}