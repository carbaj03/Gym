package com.acv.gym.data

import com.acv.gym.data.local.Cache
import com.acv.gym.domain.GenericExceptions
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doThrow
import org.mockito.runners.MockitoJUnitRunner
import java.lang.Exception


@RunWith(MockitoJUnitRunner::class)
class LaunchAppLocalGatewayImplTest {

    @Mock lateinit var sharedPreferences: Cache
    private lateinit var launchAppLocalGatewayImpl: LaunchAppLocalGatewayImpl

    @Before
    fun setUp() {
        launchAppLocalGatewayImpl = LaunchAppLocalGatewayImpl(sharedPreferences)
    }

    @Test
    fun shouldNotHappyCaseWhenNotThrowException() {
        doThrow(Exception::class.java).`when`(sharedPreferences).get(LaunchAppLocalGatewayImpl.KEY_IS_FIRST_TIME_LAUNCH_APP, true)

        val launchAppModel = launchAppLocalGatewayImpl.obtainLaunchApp()

        Assert.assertEquals(true, launchAppModel.isLeft())
    }

    @Test
    fun shouldHappyCaseWhenIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGatewayImpl.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(true)

        val launchAppModel = launchAppLocalGatewayImpl.obtainLaunchApp()

        Assert.assertEquals(true, launchAppModel.isRight())
    }

    @Test
    fun shouldReturnTrueWhenIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGatewayImpl.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(true)

        val launchAppModel = launchAppLocalGatewayImpl.obtainLaunchApp()

        launchAppModel.map { Assert.assertEquals(true, it.isFirstTime) }
    }

    @Test
    fun shouldReturnFalseWhenNotIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGatewayImpl.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(false)

        val launchAppModel = launchAppLocalGatewayImpl.obtainLaunchApp()

        launchAppModel.map { Assert.assertEquals(false, it.isFirstTime) }
    }
}