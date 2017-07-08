package com.acv.gym.domain.usecase.splash

import com.acv.gym.domain.SharedPreference
import com.nhaarman.mockito_kotlin.mock
import kategory.Option
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CheckSplashUseCaseTest {

    val gateway: SharedPreference = mock()

    lateinit var checkSplashUseCase: CheckSplashUseCase

    @Before
    fun setUp() {
        checkSplashUseCase = CheckSplashUseCase(gateway)
    }

    @Test
    fun shouldObtainLaunchAppWhenCallUseCase() {
        val command = Option.None
        checkSplashUseCase.execute(command)

        verify(gateway, times(1)).getLaunchApp()
    }
}