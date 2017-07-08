package com.acv.gym.domain.usecase.exercise.type

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.ExerciseTypeCommand
import com.acv.gym.domain.usecase.Id
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Option
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
        val id = Id("1")
        val command = Option.Some(ExerciseTypeCommand(id))
        useCase.execute(command)

        verify(gateway, times(1)).getExerciseTypesBy(id)
    }
}