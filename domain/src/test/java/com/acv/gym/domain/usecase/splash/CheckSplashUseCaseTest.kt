package com.acv.gym.domain.usecase.splash

import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.usecase.EmptyCommand
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CheckSplashUseCaseTest {

    val gateway: LaunchAppGateway = mock()

    lateinit var checkSplashUseCase: CheckSplashUseCase

    @Before
    fun setUp() {
        checkSplashUseCase = CheckSplashUseCase(gateway)
    }

    @Test
    fun shouldObtainLaunchAppWhenCallUseCase() {
        val command = EmptyCommand()
        checkSplashUseCase.execute(command)

        verify(gateway, times(1)).obtain(command)
    }
}