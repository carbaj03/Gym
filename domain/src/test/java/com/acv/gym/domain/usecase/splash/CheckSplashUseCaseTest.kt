package com.acv.gym.domain.usecase.splash

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import org.funktionale.either.Disjunction
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CheckSplashUseCaseTest {

    @Mock
    lateinit var gateway: LaunchAppLocalGateway

    lateinit var checkSplashUseCase: CheckSplashUseCase

    @Before
    fun setUp() {
        checkSplashUseCase = CheckSplashUseCase(gateway)
    }

    @Test
    fun shouldObtainLaunchAppWhenCallUseCase() {
        checkSplashUseCase.execute(Any())

        verify(gateway, times(1)).obtainLaunchApp()
    }

//    @Test
//    fun shouldThrowGenericError() {
//        `when`(gateway.obtainLaunchApp()).thenReturn(Disjunction.left(GenericExceptions.ServerError()))
//
//        val execute = checkSplashUseCase.execute(Any())
//
//        execute.onComplete { Assert.assertTrue(it.swap().get() is GenericExceptions.ServerError) }
//    }
}