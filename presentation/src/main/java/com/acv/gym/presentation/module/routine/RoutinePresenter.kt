package com.acv.gym.presentation.module.routine

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.routine.GetRoutineUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class RoutinePresenter(
        view: RoutineView,
        val useCase: GetRoutineUseCase,
        val invoker: InteractorInvoker
) : Presenter<RoutineView>(view) {
    fun loadRoutines() =
            InteractorExecution(
                    interactor = useCase,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(routines: List<Routine>) = view.show(routines)

    private fun manageExceptions(exceptions: GenericExceptions) = when (exceptions) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }

    fun checkRoutines(routine: Routine) = view.goToTemplate(routine.id)
}