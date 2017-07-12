package com.acv.gym.presentation.module.session.set

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.SessionCommand
import com.acv.gym.domain.service.session.ViewSet
import com.acv.gym.domain.service.session.ViewSetRequest
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.acv.gym.presentation.invoker.invoke
import com.acv.gym.presentation.model.SessionSetVM
import com.acv.gym.presentation.model.map
import kategory.Option

open class SessionSetPresenter(
        view: SessionSetView,
        val useCase: ViewSet,
        val invoker: ServiceInvoker
) : Presenter<SessionSetView>(view) {

    fun loadSessionSet(id: Option<Id>) = invoker invoke Logic(
            service = useCase,
            params = id.map { ViewSetRequest(SessionExerciseId(it.value)) } ,
            result = { happyCase(it) },
            error = { manageExceptions(it) })

    private fun happyCase(sessionSet: List<Set>) = view.show(sessionSet.map { it.map() })

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkSessionSet(it: SessionSetVM) = view.showClick(it.id)
}