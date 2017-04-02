package com.acv.gym.presentation.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.UseCase
import com.acv.gym.presentation.core.Future
import com.acv.gym.presentation.core.InteractorExecution
import com.acv.gym.presentation.core.InteractorInvoker
import org.funktionale.either.Disjunction
import org.mockito.Matchers.any
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.mock

object TestInteractorInvoker {

    fun create(): InteractorInvoker {
        val interactorInvoker = mock(InteractorInvoker::class.java)
        val interactorExecution = mock(InteractorExecution::class.java)
        doAnswer { invocation ->
            val execution = invocation.arguments[0] as InteractorExecution<*,*,*>
            val execute = execution.execute(interactorInvoker)
            execute.onComplete { renderFeedResult(it) }
            Disjunction.left(GenericExceptions::class.java)
        }.`when`(interactorInvoker).execute(interactorExecution)
        return interactorInvoker
    }

    fun renderFeedResult(result: Disjunction<*, *>): Any? = result
//            when (result) {
//                is Disjunction.Left -> manageExceptions(result.swap().get())
//                is Disjunction.Right -> result.map { if (it.isFirstTime) view.showSplash() }
//            }

//    private fun manageExceptions(exceptions: GenericExceptions) =
//            when (exceptions) {
//                is GenericExceptions.NetworkError -> view.renderNetworkError()
//                is GenericExceptions.ServerError -> view.renderServerError()
//            }
}
