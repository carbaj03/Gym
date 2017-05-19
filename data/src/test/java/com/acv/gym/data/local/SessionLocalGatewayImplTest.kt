package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.SessionExerciseLocalDataSource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

/**
 * Created by alejandro on 10/04/17.
 */
class SessionLocalGatewayImplTest {

    lateinit var getSessionLocalGateway: SessionLocalGateway

    var dataSource: SessionExerciseLocalDataSource = mock()

    @Before
    fun setUp() {
        getSessionLocalGateway = SessionLocalGateway(dataSource)
    }

//    @Test
//    fun shouldNotHappyCaseWhenThrowException() {
//        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()
//
//        val routines = getSessionLocalGateway.obtain(Option.None)
//
//        Assert.assertEquals(true, routines.isLeft)
//    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(Either.Right(listOf()))

        val routines = getSessionLocalGateway.obtain(Option.None)

        Assert.assertEquals(true, routines.isRight)
    }
}