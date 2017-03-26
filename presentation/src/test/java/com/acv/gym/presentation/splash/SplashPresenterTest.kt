package com.acv.gym.presentation.splash

import com.acv.gym.presentation.TestViewInjector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashPresenterTest {

    @Mock
    lateinit var view: SplashView

    lateinit var presenter: SplashPresenter

    @Before
    fun setUp() {
        presenter = SplashPresenter(TestViewInjector())
        presenter.attachView(view)
    }

    @Test
    fun shouldShowSplash() {
        Mockito.verify(view).showSplash()
    }
}