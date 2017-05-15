package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.RoutineLocalDataSource
import com.acv.gym.domain.gateway.RoutineGateway
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class RoutineLocalGatewayImplTest {

    lateinit var gateway: RoutineGateway
    val dataSource: RoutineLocalDataSource = mock()

    @Before
    fun setUp() {
        gateway = RoutineLocalGateway(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isLeft)
    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(listOf())

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isRight)
    }
}