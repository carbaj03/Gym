package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.usecase.EmptyCommand
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by alejandro on 14/04/2017.
 */
class GetMuscleGroupsUseCaseTest {

    lateinit var getMuscleGroupsUseCase : GetMuscleGroupsUseCase
    var muscleGroupGateway : MuscleGroupLocalGateway = mock()

    @Before
    fun setUp() {
        getMuscleGroupsUseCase = GetMuscleGroupsUseCase(muscleGroupGateway)
    }

    @Test
    fun `should get muscle groups When execute`() {
        val command = EmptyCommand()
        getMuscleGroupsUseCase.execute(command)

        verify(muscleGroupGateway, times(1)).obtain(command)
    }
}