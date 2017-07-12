package com.acv.gym.presentation.module.splash

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.service.Command
import com.acv.gym.domain.service.splash.CheckSplashUseCase
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import kategory.Either
import kategory.Option
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
        `when`(checkSplashUseCase.execute(Option.None)).thenReturn(Either.Right(listOf(LaunchApp(true))))

        presenter.loadSplash()

        verify(view).show(emptyList())
    }

    @Test
    fun `should show server error When splash fail`() {
        `when`(checkSplashUseCase.execute(Option.None)).thenReturn(Either.Left(GenericError.ServerError))

        presenter.loadSplash()

        verify(view).showServerError()
    }

    @Test
    fun `should show network error When not connection`() {
        `when`(checkSplashUseCase.execute(Option.None)).thenReturn(Either.Left(GenericError.NetworkError))

        presenter.loadSplash()

        verify(view).showNetworkError()
    }
}