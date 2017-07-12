package com.acv.gym.domain.service.routine

import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Option
import org.junit.Before
import org.junit.Test

class GetRoutineUseCaseTest {

    lateinit var getRoutinesUseCase: GetRoutineUseCase
    val getRoutinesLocalGateway: GymGateway = mock()

    @Before
    fun setUp() {
        getRoutinesUseCase = GetRoutineUseCase(getRoutinesLocalGateway)
    }

    @Test
    fun shouldCallObtainWhenExecute() {
        val command = Option.None
        getRoutinesUseCase.execute(command)

        verify(getRoutinesLocalGateway, times(1)).getAllRoutines()
    }
}