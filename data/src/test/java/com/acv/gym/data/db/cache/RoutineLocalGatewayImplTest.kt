package com.acv.gym.data.db.cache

import com.acv.gym.data.RoutineGateway
import com.acv.gym.data.db.cache.datasource.RoutineLocalDataSource
import com.acv.gym.domain.RoutineGateway
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class RoutineLocalGatewayImplTest {

    lateinit var gateway: com.acv.gym.domain.RoutineGateway
    val dataSource: RoutineLocalDataSource = mock()

    @Before
    fun setUp() {
        gateway = com.acv.gym.data.RoutineGateway(dataSource)
    }

//    @Test
//    fun shouldNotHappyCaseWhenThrowException() {
//        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()
//
//        val routines = gateway.obtain(Option.None)
//
//        Assert.assertEquals(true, routines.isLeft)
//    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(Either.Right(listOf()))

        val routines = gateway.obtain(Option.None)

        Assert.assertEquals(true, routines.isRight)
    }
}