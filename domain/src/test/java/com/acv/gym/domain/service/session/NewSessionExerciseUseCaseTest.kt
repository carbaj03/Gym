package com.acv.gym.domain.service.session

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.NewSessionCommand
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Either
import kategory.Option
import org.junit.Before
import org.junit.Test

/**
 * Created by alejandro on 8/06/17.
 */
class NewSessionExerciseUseCaseTest {
    lateinit var useCase: AddSessionExercise

    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        useCase = AddSessionExercise(gateway)
    }

    @Test
    fun `should persist all exercises When execute`() {
        val command = Option.Some(NewSessionCommand(listOf()))
        useCase.execute(command)

        verify(gateway, times(1)).persistSessionExercise(listOf())
    }


    private fun getSessionExercises() = Either.Right(listOf(SessionExercise(Id(), Exercise("", "", "", ""), emptyList(), Id())))
}