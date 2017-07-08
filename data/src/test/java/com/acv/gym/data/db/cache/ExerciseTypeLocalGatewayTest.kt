package com.acv.gym.data.db.cache

import com.acv.gym.data.GymGatewayImpl
import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import kategory.Either
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ExerciseTypeLocalGatewayTest {
    lateinit var gateway: GymGateway
    val dataSource: GymDataSource = mock()

    @Before
    fun setUp() {
        gateway = GymGatewayImpl(dataSource)
    }

    @Test
    fun shouldHappyCaseWhenGetAllExerciseType() {
        Mockito.`when`(dataSource.getAllExerciseTypes()).thenReturn(Either.Right(listOf()))

        val routines = gateway.getAllExerciseTypes()

        Assert.assertEquals(true, routines.isRight)
    }
}