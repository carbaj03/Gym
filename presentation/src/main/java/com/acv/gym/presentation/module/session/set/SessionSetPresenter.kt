package com.acv.gym.presentation.module.session.set

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.SessionCommand
import com.acv.gym.domain.usecase.session.GetSessionSetUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Interactor
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option

open class SessionSetPresenter(
        view: SessionSetView,
        val useCase: GetSessionSetUseCase,
        val invoker: InteractorInvoker
) : Presenter<SessionSetView>(view) {

    fun loadSessionSet(id: Option<Id>) =
            Interactor(
                    interactor = useCase,
                    params = id.map(::SessionCommand),
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(sessionSet: List<SessionSet>) = view.show(sessionSet)

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkSessionSet(it: SessionSet) = view.showClick(it.id)
}