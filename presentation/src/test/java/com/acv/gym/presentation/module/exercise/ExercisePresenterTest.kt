package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.exercise.GetExercisesUseCase
import com.acv.gym.presentation.Id
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 15/04/2017.
 */
class ExercisePresenterTest {

    lateinit var presenter: ExercisePresenter
    val view: ExerciseView = mock()
    val useCase: GetExercisesUseCase = mock()

    @Before
    fun setUp() {
        presenter = ExercisePresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show exercises When call load exercise`() {
        val exercise = getExercise()
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Right(exercise))

        presenter.loadExercises(Id(""))

        verify(view, times(1)).show(exercise)
    }

    @Test
    fun `should show error network When is network exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.NetworkError()))

        presenter.loadExercises(Id(""))

        verify(view, times(1)).showNetworkError()
    }

    @Test
    fun `should show error server When is server exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.ServerError()))

        presenter.loadExercises(Id(""))

        verify(view, times(1)).showServerError()
    }

    private fun getExercise() = listOf(Exercise("", ""))
}