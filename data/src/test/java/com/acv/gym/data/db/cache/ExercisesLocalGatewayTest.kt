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

class ExercisesLocalGatewayTest {
    lateinit var gateway: GymGateway
    val dataSource: GymDataSource = mock()

    @Before
    fun setUp() {
        gateway = GymGatewayImpl(dataSource)
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
    fun shouldHappyCaseWhenGetExercises() {
        Mockito.`when`(dataSource.getAllExercises()).thenReturn(Either.Right(listOf()))

        val routines = gateway.getAllExercises()

        Assert.assertEquals(true, routines.isRight)
    }
}