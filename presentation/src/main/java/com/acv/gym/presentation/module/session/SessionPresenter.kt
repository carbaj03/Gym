package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionId
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.SessionCommand
import com.acv.gym.domain.service.session.ViewSessionExercise
import com.acv.gym.domain.service.session.ViewSessionExerciseRequest
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.acv.gym.presentation.invoker.invoke
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.model.map
import kategory.Option

sealed class Mode {
    object Edit : Mode()
    object View : Mode()
}

open class SessionPresenter(
        view: SessionView,
        val service: ViewSessionExercise,
        val invoker: ServiceInvoker
) : Presenter<SessionView>(view) {
    var mode: Mode = Mode.View
    var selected: List<SessionExerciseVM> = listOf()

    fun loadSessions(id: Option<Id>) = invoker invoke Logic(
            service = service,
            params = id.map { ViewSessionExerciseRequest(SessionId(it.value)) },
            result = { happyCase(it) },
            error = { manageExceptions(it) }
    )

    private fun happyCase(sessionExercises: List<SessionExercise>) =
            view.show(sessionExercises.map { it.map() })

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        GenericError.NetworkError -> view.showNetworkError()
        GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(it: SessionExerciseVM) = view.showClick(it.id)

    fun delete() {
        mode = changeMode()
    }

    fun changeMode(): Mode = when (mode) {
        Mode.Edit -> disbledDeleteMode()
        Mode.View -> {
            view.enabledDeleteMode()
            Mode.Edit
        }
    }

    private fun disbledDeleteMode(): Mode {
        view.disabledDeleteMode()
        return Mode.View
    }

    fun back() {
        mode = disabledMode()
    }

    fun disabledMode() = when (mode) {
        Mode.Edit -> disbledDeleteMode()
        Mode.View -> {
            view.goBack()
            Mode.Edit
        }
    }

    fun sessionSelected(sessionExercise: SessionExerciseVM) =
            selected.contains(sessionExercise)
                    .apply { selected -= sessionExercise }
                    .also { selected += sessionExercise }

}