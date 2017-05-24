package com.acv.gym.data.db.cache

import com.acv.gym.data.GymGatewayImpl
import com.acv.gym.data.db.GymDataSource
import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 14/04/2017.
 */
class MuscleGroupLocalGatewayImplTest {

    lateinit var muscleGroupGatewayImpl: GymGateway
    val dataSource: GymDataSource = mock()

    @Before
    fun setUp() {
        muscleGroupGatewayImpl = GymGatewayImpl(dataSource)
    }

    @Test
    fun shouldReturnAllMuscleGroupsWhenCallObtain() {
        Mockito.`when`(dataSource.getAllMuscleGroups()).thenReturn(Either.Right(listOf()))

        muscleGroupGatewayImpl.getAllMuscleGroups()

        verify(dataSource, times(1)).getAllMuscleGroups()
    }

//    @Test
//    fun shouldReturnServerErrorWhenThrowsException() {
//        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll()
//
//        val muscleGroups = muscleGroupGatewayImpl.obtain(Option.None)
//
//        Assert.assertEquals(true, muscleGroups.isLeft)
//    }
}