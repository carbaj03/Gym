package com.acv.gym.presentation.module.session

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.domain.usecase.session.GetSessionUseCase
import com.acv.gym.domain.usecase.session.SessionCommand
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 10/04/17.
 */
class SessionPresenterTest {

    lateinit var presenter: SessionPresenter

    val view: SessionView = mock()
    val useCase: GetSessionUseCase = mock()
    val command: SessionCommand = SessionCommand("")

    @Before
    fun setUp() {
        presenter = SessionPresenter(view, useCase, TestInteractorInvoker.create(command))
    }

    @Test
    fun `should show session When call use case`() {
        var listOf = getSession()
        Mockito.`when`(useCase.execute(command)).thenReturn(Either.Right(getSession()))

        presenter.loadSessions(command)

        verify(view, times(1)).show(listOf)
    }

    @Test
    fun `should show server error When get session fail`() {
        Mockito.`when`(useCase.execute(SessionCommand(""))).thenReturn(Either.Left(GenericExceptions.ServerError()))

        presenter.loadSessions(SessionCommand(""))

        verify(view, times(1)).renderServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        Mockito.`when`(useCase.execute(SessionCommand(""))).thenReturn(Either.Left(GenericExceptions.NetworkError()))

        presenter.loadSessions(SessionCommand(""))

        verify(view, times(1)).renderNetworkError()
    }

    private fun getSession() = listOf(SessionExerciseModel("", "", 0f, 0, ""))

}