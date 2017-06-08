package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import katz.Option
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 15/04/2017.
 */
class ExerciseTypePresenterTest {

    lateinit var presenter: ExerciseTypePresenter
    val view: ExerciseTypeView = mock()
    val useCase: GetExerciseTypesUseCase = mock()

    @Before
    fun setUp() {
        presenter = ExerciseTypePresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show exercise type When call load exercise type`() {
        val exerciseType = getExerciseType()
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Right(exerciseType))

        presenter.loadExerciseType(Option(Id("")))

        verify(view, times(1)).show(exerciseType)
    }

    @Test
    fun `should show error network When is network exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.NetworkError))

        presenter.loadExerciseType(Option(Id("")))

        verify(view, times(1)).showNetworkError()
    }

    @Test
    fun `should show error server When is server exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.ServerError))

        presenter.loadExerciseType(Option(Id("")))

        verify(view, times(1)).showServerError()
    }

    private fun getExerciseType() = listOf(ExerciseType("", ""))
}