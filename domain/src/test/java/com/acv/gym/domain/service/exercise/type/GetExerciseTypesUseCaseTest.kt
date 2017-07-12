package com.acv.gym.domain.service.exercise.type

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.ExerciseTypeCommand
import com.acv.gym.domain.service.Id
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Option
import org.junit.Before
import org.junit.Test

class GetExerciseTypesUseCaseTest {
    lateinit var useCase: ViewExerciseType
    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        useCase = ViewExerciseType(gateway)
    }

    @Test
    fun `should return all exercise types When execute`() {
        val id = Id("1")
        val command = Option.Some(ViewExerciseTypeRequest(id))
        useCase.execute(command)

        verify(gateway, times(1)).getExerciseTypesBy(id)
    }
}