package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.module.splash.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.funktionale.either.Disjunction
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 15/04/2017.
 */
class ExerciseTypePresenterTest {

    lateinit var presenter: ExerciseTypePresenter
    val view : ExerciseTypeView = mock()
    val useCase : GetExerciseTypesUseCase = mock()

    @Before
    fun setUp() {
        presenter = ExerciseTypePresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show exercise type When call load exercise type`() {
        val exerciseType = getExerciseType()
        Mockito.`when`(useCase.execute(EmptyCommand())).thenReturn(Disjunction.right(exerciseType))

        presenter.loadExerciseType()

        verify(view, times(1)).show(exerciseType)
    }

    private fun  getExerciseType() = listOf(ExerciseTypeModel("", ""))
}