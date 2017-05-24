package com.acv.gym.data.db.cache

import com.acv.gym.data.GymGatewayImpl
import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 10/04/17.
 */
class SessionLocalGatewayImplTest {

    lateinit var gateway: GymGateway

    var dataSource: GymDataSource = mock()

    @Before
    fun setUp() {
        gateway = GymGatewayImpl(dataSource)
    }

//    @Test
//    fun shouldNotHappyCaseWhenThrowException() {
//        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()
//
//        val routines = getGateway.obtain(Option.None)
//
//        Assert.assertEquals(true, routines.isLeft)
//    }

    @Test
    fun shouldHappyCaseWhenGetAllSession() {
        Mockito.`when`(dataSource.getAllSession()).thenReturn(Either.Right(listOf()))

        val routines = gateway.getAllSesion()

        Assert.assertEquals(true, routines.isRight)
    }
}