package com.acv.gym.domain.service.exercise

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.Id
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Option
import org.junit.Before
import org.junit.Test

class GetExerciseUseCaseTest {
    lateinit var service: ViewAllExercise
    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        service = ViewAllExercise(gateway)
    }

    @Test
    fun `should return all exercises When execute`() {
        val id = Id("1")
        val command = Option.Some(ViewAllExerciseRequest(id, id))
        service.execute(command)

        verify(gateway, times(1)).getExercisesBy(id,id)
    }
}