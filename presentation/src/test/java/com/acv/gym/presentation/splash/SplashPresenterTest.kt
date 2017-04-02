package com.acv.gym.presentation.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.core.Future
import com.acv.gym.presentation.core.InteractorExecution
import com.acv.gym.presentation.core.InteractorInvoker
import kotlinx.coroutines.experimental.runBlocking
import org.funktionale.either.Disjunction
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashPresenterTest {

    @Mock
    lateinit var view: SplashView

    lateinit var presenter: SplashPresenter

    @Mock
    lateinit var checkSplashUseCase : CheckSplashUseCase

    @Before
    fun setUp() {
        presenter = SplashPresenter(checkSplashUseCase, TestInteractorInvoker.create())
        presenter.attachView(view)
    }

    @Test
    fun shouldShowSplash() {
        `when`(checkSplashUseCase.execute(Any())).thenReturn(Disjunction.right(LaunchAppModel(true)))

        runBlocking {
            presenter.loadSplash()
        }

        Mockito.verify(view).showSplash()
    }

//    suspend fun getSplash(): Future<Disjunction<GenericExceptions, LaunchAppModel>> {
//        return InteractorExecution(checkSplashUseCase, Any()).execute(interactorInvokerImp)
//    }
}