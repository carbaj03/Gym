package com.acv.gym.presentation.module.session.set

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.SessionCommand
import com.acv.gym.domain.service.session.GetSessionSetUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.invoker.invoke
import com.acv.gym.presentation.model.SessionSetVM
import com.acv.gym.presentation.model.map
import kategory.Option

open class SessionSetPresenter(
        view: SessionSetView,
        val useCase: GetSessionSetUseCase,
        val invoker: UseCaseInvoker
) : Presenter<SessionSetView>(view) {

    fun loadSessionSet(id: Option<Id>) = invoker invoke UseCase(
            interactor = useCase,
            params = id.map(::SessionCommand),
            result = { happyCase(it) },
            error = { manageExceptions(it) })

    private fun happyCase(sessionSet: List<SessionSet>) = view.show(sessionSet.map { it.map() })

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkSessionSet(it: SessionSetVM) = view.showClick(it.id)
}