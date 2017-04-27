package com.acv.gym.data.local

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.RoutineDataModel
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class RoutineLocalGatewayImplTest {

    lateinit var gateway: RoutineLocalGateway
    val dataSource: DataSource<RoutineDataModel> = mock()

    @Before
    fun setUp() {
        gateway = RoutineLocalGatewayImpl(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll(any())

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isLeft())
    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll(any())).thenReturn(listOf())

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isRight())
    }
}