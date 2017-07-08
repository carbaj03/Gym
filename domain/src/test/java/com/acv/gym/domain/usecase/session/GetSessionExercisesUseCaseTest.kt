package com.acv.gym.domain.usecase.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.SessionCommand
import com.nhaarman.mockito_kotlin.mock
import kategory.Either
import kategory.Option
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.`when`

/**
 * Created by alejandro on 10/04/17.
 */
class GetSessionExercisesUseCaseTest {

    lateinit var getSessionUseCase: GetSessionExercisesUseCase

    val gateway: GymGateway = mock()

    @Before
    fun setUp() {
        getSessionUseCase = GetSessionExercisesUseCase(gateway)
    }

    @Test
    fun `should return model`() {
        val sessions = getSession()
        `when`(gateway.getSessionExercisesBy(Id(""))).thenReturn(sessions)

        val response = getSessionUseCase.execute(Option.Some(SessionCommand(Id(""))))

        Assert.assertSame(sessions, response)
    }

    @Test @Ignore
    fun `should return error`() {
        val sessions = getErrorSession()
        `when`(gateway.getAllSessionExercises()).thenReturn(sessions)

        val response = getSessionUseCase.execute(Option.None)

        Assert.assertSame(sessions, response)
    }

    private fun getSession() = Either.Right(listOf(SessionExercise(Id(), Exercise("","","",""), emptyList(), Id())))

    private fun getErrorSession() = Either.Left(GenericError.NetworkError)

}