package com.acv.gym.data.db.cache

import com.acv.gym.data.SessionGateway
import com.acv.gym.data.db.room.datasource.SessionExerciseDataSource
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

    lateinit var getSessionLocalGateway: SessionGateway

    var dataSource: SessionExerciseDataSource = mock()

    @Before
    fun setUp() {
        getSessionLocalGateway = SessionGateway(dataSource)
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
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(Either.Right(listOf()))

        val routines = getSessionLocalGateway.obtain(Option.None)

        Assert.assertEquals(true, routines.isRight)
    }
}