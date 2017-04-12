package com.acv.gym.presentation.routine

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.routine.GetRoutinesUseCase
import com.acv.gym.domain.usecase.session.SessionCommand
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class RoutinesPresenter(val getRoutinesUseCase: GetRoutinesUseCase,
                             val interactorInvokerImp: InteractorInvoker) : Presenter<RoutinesView>() {
    fun loadRoutines(command: Command = EmptyCommand()){
        InteractorExecution(getRoutinesUseCase, command)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it) }
                .execute(interactorInvokerImp)
    }

    private fun happyCase(routines: List<RoutineModel>) : Unit {
        view.show(routines)
    }

    private fun manageExceptions(exceptions: GenericExceptions) : Unit {
        when (exceptions) {
            is GenericExceptions.NetworkError -> view.renderNetworkError()
            is GenericExceptions.ServerError -> view.renderServerError()
        }
    }

    fun checkRoutines(routine: RoutineModel) {
        view.goToTemplate(routine.id)
    }
}