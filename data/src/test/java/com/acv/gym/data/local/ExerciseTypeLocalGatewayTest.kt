package com.acv.gym.data.local

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.ExerciseTypeDataModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class ExerciseTypeLocalGatewayTest {
    lateinit var gateway: ExerciseTypeLocalGateway
    val dataSource: DataSource<ExerciseTypeDataModel> = mock()

    @Before
    fun setUp() {
        gateway = ExerciseTypeLocalGateway(dataSource)
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