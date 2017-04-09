package com.acv.gym.data.local

import com.acv.gym.data.RoutinesDataSource
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class GetRoutinesLocalGatewayImplTest {

    lateinit var gateway: RoutineLocalGateway
    val dataSource: RoutinesDataSource = mock()

    @Before
    fun setUp() {
        gateway = GetRoutinesLocalGatewayImpl(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isLeft())
    }


    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(listOf())

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isRight())
    }
}