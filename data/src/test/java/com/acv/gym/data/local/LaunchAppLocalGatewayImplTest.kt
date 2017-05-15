package com.acv.gym.data.local

import com.acv.gym.domain.usecase.EmptyCommand
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doThrow
import java.lang.Exception


class LaunchAppLocalGatewayImplTest {

    val sharedPreferences: Cache = mock()
    private lateinit var launchAppLocalGatewayImpl: LaunchAppLocalGateway

    @Before
    fun setUp() {
        launchAppLocalGatewayImpl = LaunchAppLocalGateway(sharedPreferences)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        doThrow(Exception::class.java).`when`(sharedPreferences).get(LaunchAppLocalGateway.KEY_IS_FIRST_TIME_LAUNCH_APP, true)

        val launchAppModel = launchAppLocalGatewayImpl.obtain()

        Assert.assertEquals(true, launchAppModel.isLeft)
    }

    @Test
    fun shouldHappyCaseWhenIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGateway.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(true)

        val launchAppModel = launchAppLocalGatewayImpl.obtain()

        Assert.assertEquals(true, launchAppModel.isRight)
    }

    @Test
    fun shouldReturnTrueWhenIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGateway.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(true)

        val launchAppModel = launchAppLocalGatewayImpl.obtain()

        launchAppModel.map { Assert.assertEquals(true, it[0].isFirstTime) }
    }

    @Test
    fun shouldReturnFalseWhenNotIsFirtsTime() {
        `when`(sharedPreferences.get(LaunchAppLocalGateway.KEY_IS_FIRST_TIME_LAUNCH_APP, true))
                .thenReturn(false)

        val launchAppModel = launchAppLocalGatewayImpl.obtain(EmptyCommand())

        launchAppModel.map { Assert.assertEquals(false, it[0].isFirstTime) }
    }
}