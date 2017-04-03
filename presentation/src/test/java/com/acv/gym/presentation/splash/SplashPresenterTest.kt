package com.acv.gym.presentation.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.funktionale.either.Disjunction
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`


class SplashPresenterTest {

    val view: SplashView = mock()

    val checkSplashUseCase: CheckSplashUseCase = mock()

    lateinit var presenter: SplashPresenter

    @Before
    fun setUp() {
        presenter = SplashPresenter(checkSplashUseCase, TestInteractorInvoker.create())
        presenter.attachView(view)
    }

    @Test
    fun shouldShowSplashWhenCallUseCase() {
        `when`(checkSplashUseCase.execute(any())).thenReturn(Disjunction.right(LaunchAppModel(true)))

        presenter.loadSplash()

        verify(view).showSplash()
    }

    @Test
    fun `should show server error When splash fail`() {
        `when`(checkSplashUseCase.execute(any())).thenReturn(Disjunction.left(GenericExceptions.ServerError()))

        presenter.loadSplash()

        verify(view).renderServerError()
    }

}