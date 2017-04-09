package com.acv.gym.domain.usecase.routine

import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class GetRoutinesUseCaseTest {

    lateinit var getRoutinesUseCase: GetRoutinesUseCase
    val getRoutinesLocalGateway: RoutineLocalGateway = mock()

    @Before
    fun setUp() {
        getRoutinesUseCase = GetRoutinesUseCase(getRoutinesLocalGateway)
    }

    @Test
    fun shouldCallObtainWhenExecute() {
        getRoutinesUseCase.execute(Any())

        verify(getRoutinesLocalGateway, times(1)).obtain()
    }
}