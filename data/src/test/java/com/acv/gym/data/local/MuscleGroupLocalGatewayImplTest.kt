package com.acv.gym.data.local

import com.acv.gym.data.DataSource
import com.acv.gym.data.model.MuscleGroupDataModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

/**
 * Created by alejandro on 14/04/2017.
 */
class MuscleGroupLocalGatewayImplTest {

    lateinit var muscleGroupGatewayImpl: MuscleGroupLocalGatewayImpl
    val dataSource: DataSource<MuscleGroupDataModel> = mock()

    @Before
    fun setUp() {
        muscleGroupGatewayImpl = MuscleGroupLocalGatewayImpl(dataSource)
    }

    @Test
    fun shouldReturnAllMuscleGroupsWhenCallObtain() {
        Mockito.`when`(dataSource.getAll(any())).thenReturn(listOf())

        muscleGroupGatewayImpl.obtain()

        verify(dataSource, times(1)).getAll(any())
    }

    @Test
    fun shouldReturnServerErrorWhenThrowsException() {
        Mockito.doThrow(Exception::class.java).`when`(dataSource).getAll(any())

        val muscleGroups = muscleGroupGatewayImpl.obtain()

        Assert.assertEquals(true, muscleGroups.isLeft())
    }
}