package com.acv.gym.presentation.routine

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.usecase.routine.GetRoutinesUseCase
import com.acv.gym.presentation.splash.SplashView
import com.acv.gym.presentation.splash.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.funktionale.either.Disjunction
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RoutinesPresenterTest {
    lateinit var presenter: RoutinesPresenter

    val useCase: GetRoutinesUseCase = mock()
    val view: RoutinesView = mock()

    @Before
    fun setUp() {
        presenter = RoutinesPresenter(useCase, TestInteractorInvoker.create())
        presenter.attachView(view)
    }

    @Test
    fun `should show routines When call use case`() {
        var listOf = listOf(RoutineModel("1", "Full Body", ""),
                RoutineModel("2", "Torso/Pierna", ""), RoutineModel("3", "Push/Pull/Leg", ""))
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.right(listOf))

        presenter.loadRoutines()

        verify(view, times(1)).show(listOf)
    }

    @Test
    fun `should show server error When get routines fail`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.left(GenericExceptions.ServerError()))

        presenter.loadRoutines()

        verify(view, times(1)).renderServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.left(GenericExceptions.NetworkError()))

        presenter.loadRoutines()

        verify(view, times(1)).renderNetworkError()
    }
}