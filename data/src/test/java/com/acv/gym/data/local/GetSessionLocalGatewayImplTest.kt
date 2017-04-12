package com.acv.gym.data.local

import com.acv.gym.data.SessionDataSource
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

/**
 * Created by alejandro on 10/04/17.
 */
class GetSessionLocalGatewayImplTest {

    lateinit var getSessionLocalGateway: GetSessionLocalGatewayImpl

    var dataSource: SessionDataSource = mock()

    @Before
    fun setUp() {
        getSessionLocalGateway = GetSessionLocalGatewayImpl(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()

        val routines = getSessionLocalGateway.obtain()

        Assert.assertEquals(true, routines.isLeft())
    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(listOf())

        val routines = getSessionLocalGateway.obtain()

        Assert.assertEquals(true, routines.isRight())
    }
}