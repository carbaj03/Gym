package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.Id
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Option
import org.junit.Before
import org.junit.Test

class GetExerciseUseCaseTest {
    lateinit var useCase: GetExercisesUseCase
    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        useCase = GetExercisesUseCase(gateway)
    }

    @Test
    fun `should return all exercises When execute`() {
        val id = Id("1")
        val command = Option.Some(ExerciseCommand(id))
        useCase.execute(command)

        verify(gateway, times(1)).getAllExercises()
    }
}