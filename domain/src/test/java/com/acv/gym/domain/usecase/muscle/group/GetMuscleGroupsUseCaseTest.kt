package com.acv.gym.domain.usecase.muscle.group

import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Option
import org.junit.Before
import org.junit.Test

/**
 * Created by alejandro on 14/04/2017.
 */
class GetMuscleGroupsUseCaseTest {

    lateinit var getMuscleGroupsUseCase: GetMuscleGroupsUseCase
    var muscleGroupGateway: GymGateway = mock()

    @Before
    fun setUp() {
        getMuscleGroupsUseCase = GetMuscleGroupsUseCase(muscleGroupGateway)
    }

    @Test
    fun `should get muscle groups When execute`() {
        val command = Option.None
        getMuscleGroupsUseCase.execute(command)

        verify(muscleGroupGateway, times(1)).getAllMuscleGroups()
    }
}