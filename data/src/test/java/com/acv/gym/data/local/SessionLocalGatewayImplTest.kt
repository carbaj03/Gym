package com.acv.gym.data.local

import com.acv.gym.data.SessionDataSource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

/**
 * Created by alejandro on 10/04/17.
 */
class SessionLocalGatewayImplTest {

    lateinit var getSessionLocalGateway: SessionLocalGatewayImpl

    var dataSource: SessionDataSource = mock()

    @Before
    fun setUp() {
        getSessionLocalGateway = SessionLocalGatewayImpl(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        val date = ""
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAllBy(date)

        val routines = getSessionLocalGateway.obtain(date)

        Assert.assertEquals(true, routines.isLeft())
    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        val date = ""
        Mockito.`when`(dataSource.getAllBy(date)).thenReturn(listOf())

        val routines = getSessionLocalGateway.obtain(date)

        Assert.assertEquals(true, routines.isRight())
    }
}