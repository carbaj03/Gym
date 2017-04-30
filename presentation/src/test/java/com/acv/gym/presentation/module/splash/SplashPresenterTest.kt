package com.acv.gym.presentation.module.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`


class SplashPresenterTest {

    val view: SplashView = mock()

    val checkSplashUseCase: CheckSplashUseCase = mock()

    var any: Command = mock()

    lateinit var presenter: SplashPresenter

    @Before
    fun setUp() {
        presenter = SplashPresenter(view, checkSplashUseCase, TestInteractorInvoker.create(any))
    }

    @Test
    fun `should show splash When call use case`() {
        `when`(checkSplashUseCase.execute(any)).thenReturn(Either.Right(LaunchAppModel(true)))

        presenter.loadSplash()

        verify(view).showSplash()
    }

    @Test
    fun `should show server error When splash fail`() {
        `when`(checkSplashUseCase.execute(any)).thenReturn(Either.Left(GenericExceptions.ServerError()))

        presenter.loadSplash()

        verify(view).renderServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        `when`(checkSplashUseCase.execute(any)).thenReturn(Either.Left(GenericExceptions.NetworkError()))

        presenter.loadSplash()

        verify(view).renderNetworkError()
    }
}