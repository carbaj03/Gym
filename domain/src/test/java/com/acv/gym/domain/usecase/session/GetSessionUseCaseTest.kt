package com.acv.gym.domain.usecase.session

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.SessionGateway
import com.acv.gym.domain.model.SessionExercise
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import katz.Either
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`

/**
 * Created by alejandro on 10/04/17.
 */
class GetSessionUseCaseTest {

    lateinit var getSessionUseCase: GetSessionUseCase

    val sessionLocalGateway: SessionGateway = mock()

    @Before
    fun setUp() {
        getSessionUseCase = GetSessionUseCase(sessionLocalGateway)
    }

    @Test
    fun `should return model`() {
        var sessions = getSession()
        `when`(sessionLocalGateway.obtain(any())).thenReturn(sessions)

        val response = getSessionUseCase.execute(SessionCommand(""))

        Assert.assertSame(sessions, response)
    }

    @Test
    fun `should return error`() {
        var sessions = getErrorSession()
        `when`(sessionLocalGateway.obtain(any())).thenReturn(sessions)

        val response = getSessionUseCase.execute(SessionCommand(""))

        Assert.assertSame(sessions, response)
    }

    private fun getSession() = Either.Right(listOf(SessionExercise("", "", emptyList(), "")))

    private fun getErrorSession() = Either.Left(GenericExceptions.NetworkError())

}