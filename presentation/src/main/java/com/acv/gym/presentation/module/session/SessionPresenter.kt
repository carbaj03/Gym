package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.SessionCommand
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.invoker.invoke
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.model.map
import kategory.Option

sealed class Status {
    object Edit : Status()
    object View : Status()
}

open class SessionPresenter(
        view: SessionView,
        val useCase: GetSessionExercisesUseCase,
        val invoker: UseCaseInvoker
) : Presenter<SessionView>(view) {
    var selectable: Status = Status.View
    var selected: List<SessionExerciseVM> = listOf()

    fun loadSessions(id: Option<Id>) = invoker invoke UseCase(
            interactor = useCase,
            params = id.map(::SessionCommand),
            result = { happyCase(it) },
            error = { manageExceptions(it) }
    )

    private fun happyCase(sessionExercises: List<SessionExercise>) = view.show(sessionExercises.map { it.map() })

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        GenericError.NetworkError -> view.showNetworkError()
        GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(it: SessionExerciseVM) = view.showClick(it.id)

    fun delete() = changeMode()

    fun sessionSelected(sessionExercise: SessionExerciseVM) {
        if (selected.contains(sessionExercise))
            selected -= sessionExercise
        else
            selected += sessionExercise
    }

    fun changeMode() = when (selectable) {
        Status.Edit -> {
            view.disabledDeleteMode()
            selectable = Status.View
        }
        Status.View -> {
            view.enabledDeleteMode()
            selectable = Status.Edit
        }
    }

    fun back() = when (selectable) {
        Status.Edit -> {
            view.disabledDeleteMode()
            selectable = Status.View
        }
        Status.View -> view.goBack()
    }

}