package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.service.exercise.ViewAllExercise
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import kategory.Either
import kategory.Option
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 15/04/2017.
 */
class ExercisePresenterTest {

    lateinit var presenter: ExercisePresenter
    val view: ExerciseView = mock()
    val useCase: ViewAllExercise = mock()

    @Before
    fun setUp() {
        presenter = ExercisePresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show exercises When call load exercise`() {
        val exercise = getExercise()
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Right(exercise))

        presenter.loadExercises(Option.None)

        verify(view, times(1)).show(exercise)
    }

    @Test
    fun `should show error network When is network exception`() {
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Left(GenericError.NetworkError))

        presenter.loadExercises(Option.None)

        verify(view, times(1)).showNetworkError()
    }

    @Test
    fun `should show error server When is server exception`() {
        Mockito.`when`(useCase.execute(Option.None)).thenReturn(Either.Left(GenericError.ServerError))

        presenter.loadExercises(Option.None)

        verify(view, times(1)).showServerError()
    }

    private fun getExercise() = listOf(Exercise("", "", "", ""))
}