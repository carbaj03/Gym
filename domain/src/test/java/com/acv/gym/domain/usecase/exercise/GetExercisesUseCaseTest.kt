package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.gateway.ExercisesGateway
import com.acv.gym.domain.usecase.EmptyCommand
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class GetExerciseUseCaseTest {


    lateinit var useCase: GetExercisesUseCase
    val gateway: ExercisesGateway = mock()

    @Before
    fun setUp() {
        useCase = GetExercisesUseCase(gateway)
    }

    @Test
    fun `should return all exercises When execute`() {
        val command = EmptyCommand()
        useCase.execute(command)

        verify(gateway, times(1)).obtain(command)
    }
}