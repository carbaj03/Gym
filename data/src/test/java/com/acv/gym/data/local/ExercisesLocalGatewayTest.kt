package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExercisesLocalDataSource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class ExercisesLocalGatewayTest {
    lateinit var gateway: ExercisesLocalGateway
    val dataSource: ExercisesLocalDataSource = mock()

    @Before
    fun setUp() {
        gateway = ExercisesLocalGateway(dataSource)
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