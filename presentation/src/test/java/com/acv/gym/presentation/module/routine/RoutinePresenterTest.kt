package com.acv.gym.presentation.module.routine

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.routine.GetRoutineUseCase
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RoutinePresenterTest {
    lateinit var presenter: RoutinePresenter

    val useCase: GetRoutineUseCase = mock()
    val view: RoutineView = mock()

    @Before
    fun setUp() {
        presenter = RoutinePresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show routines When call use case`() {
        val listOf = getRoutines()
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Right(listOf))

        presenter.loadRoutines()

        verify(view, times(1)).show(listOf)
    }

    @Test
    fun `should show server error When get routines fail`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericExceptions.ServerError()))

        presenter.loadRoutines()

        verify(view, times(1)).showServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericExceptions.NetworkError()))

        presenter.loadRoutines()

        verify(view, times(1)).showNetworkError()
    }

    private fun getRoutines() = listOf(Routine("", "", ""))
}