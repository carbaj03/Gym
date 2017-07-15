package com.acv.gym.domain.service.session

import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.service.Id
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
    lateinit var service: AddSessionExercise

    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        service = AddSessionExercise(gateway)
    }

    @Test
    fun `should persist all exercises When execute`() {
        val command = Option.Some(AddSessionRequest(listOf()))
        service.execute(command)

        verify(gateway, times(1)).persistSessionExercise(listOf())
    }


    private fun getSessionExercises() = Either.Right(listOf(SessionExercise(SessionExerciseId(""), Exercise("", "", "", ""), emptyList(), Id())))
}