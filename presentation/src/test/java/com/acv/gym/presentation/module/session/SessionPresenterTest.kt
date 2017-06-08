package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.SessionCommand
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import katz.Option
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 10/04/17.
 */
class SessionPresenterTest {

    lateinit var presenter: SessionPresenter

    val view: SessionView = mock()
    val useCase: GetSessionExercisesUseCase = mock()
    val command: SessionCommand = SessionCommand(Id("1"))

    @Before
    fun setUp() {
        presenter = SessionPresenter(view, useCase, TestInteractorInvoker.create(command))
    }

    @Test
    fun `should show session When call use case`() {
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Right(listOf()))

        presenter.loadSessions(Option.None)

        verify(view, times(1)).show(listOf())
    }

    @Test
    fun `should show server error When get session fail`() {
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Left(GenericError.ServerError))

        presenter.loadSessions(Option.None)

        verify(view, times(1)).showServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Left(GenericError.NetworkError))

        presenter.loadSessions(Option.None)

        verify(view, times(1)).showNetworkError()
    }
}