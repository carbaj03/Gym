package com.acv.gym.domain.usecase.splash

import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CheckSplashUseCaseTest {

    val gateway: LaunchAppLocalGateway = mock()

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
}