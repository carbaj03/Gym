package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GymGateway
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Option
import org.junit.Before
import org.junit.Test

class GetExerciseTypesUseCaseTest {


    lateinit var useCase: GetExerciseTypesUseCase
    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        useCase = GetExerciseTypesUseCase(gateway)
    }

    @Test
    fun `should return all exercise types When execute`() {
        val command = Option.None
        useCase.execute(command)

        verify(gateway, times(1)).getAllExerciseTypes()
    }
}