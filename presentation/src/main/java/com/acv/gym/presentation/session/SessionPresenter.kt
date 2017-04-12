package com.acv.gym.presentation.session

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.routine.GetRoutinesUseCase
import com.acv.gym.domain.usecase.session.GetSessionUseCase
import com.acv.gym.domain.usecase.session.SessionCommand
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class SessionPresenter(val getSessionUseCase: GetSessionUseCase,
                            val invoker: InteractorInvoker) : Presenter<SessionView>() {
    fun loadSessions(command: SessionCommand){
        InteractorExecution(getSessionUseCase, command)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it) }
                .execute(invoker)
    }

    private fun happyCase(sessionExercises: List<SessionExerciseModel>) : Unit {
        view.show(sessionExercises)
    }

    private fun manageExceptions(exceptions: GenericExceptions) : Unit {
        when (exceptions) {
            is GenericExceptions.NetworkError -> view.renderNetworkError()
            is GenericExceptions.ServerError -> view.renderServerError()
        }
    }
}