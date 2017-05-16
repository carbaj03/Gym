package com.acv.gym.presentation.module.routine

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.routine.GetRoutineUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class RoutinePresenter(
        view: RoutineView
        , val getRoutinesUseCase: GetRoutineUseCase
        , val interactorInvokerImp: InteractorInvoker
) : Presenter<RoutineView>(view) {
    fun loadRoutines() {
        InteractorExecution(getRoutinesUseCase)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it) }
                .execute(interactorInvokerImp)
    }

    private fun happyCase(routines: List<Routine>) = view.show(routines)

    private fun manageExceptions(exceptions: GenericExceptions) = when (exceptions) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }

    fun checkRoutines(routine: Routine) = view.goToTemplate(routine.id)
}