package com.acv.gym.data.local

import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.EmptyCommand
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class ExerciseTypeLocalGatewayTest {
    lateinit var gateway: ExerciseTypeLocalGateway
    val dataSource: ExerciseTypeLocalDataSource = mock()

    @Before
    fun setUp() {
        gateway = ExerciseTypeLocalGateway(dataSource)
    }

    @Test
    fun shouldNotHappyCaseWhenThrowException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isLeft)
    }

    @Test
    fun shouldHappyCaseWhenGetRoutines() {
        Mockito.`when`(dataSource.getAll()).thenReturn(listOf())

        val routines = gateway.obtain()

        Assert.assertEquals(true, routines.isRight)
    }
}