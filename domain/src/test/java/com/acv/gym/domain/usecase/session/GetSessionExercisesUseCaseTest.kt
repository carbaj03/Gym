package com.acv.gym.domain.usecase.session

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.model.SessionExercise
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import katz.Option
import org.junit.Assert
import org.junit.Before
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
        var sessions = getSession()
        `when`(gateway.getAllSessionExercises()).thenReturn(sessions)

        val response = getSessionUseCase.execute(Option.None)

        Assert.assertSame(sessions, response)
    }

    @Test
    fun `should return error`() {
        var sessions = getErrorSession()
        `when`(gateway.getAllSessionExercises()).thenReturn(sessions)

        val response = getSessionUseCase.execute(Option.None)

        Assert.assertSame(sessions, response)
    }

    private fun getSession() = Either.Right(listOf(SessionExercise("", "", emptyList(), "")))

    private fun getErrorSession() = Either.Left(GenericError.NetworkError())

}