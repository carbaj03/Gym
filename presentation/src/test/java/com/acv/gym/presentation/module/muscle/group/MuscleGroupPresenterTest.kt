package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.presentation.module.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import katz.Either
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by alejandro on 14/04/2017.
 */
class MuscleGroupPresenterTest {

    lateinit var presenter: MuscleGroupPresenter
    val view: MuscleGroupView = mock()
    val useCase: GetMuscleGroupsUseCase = mock()

    @Before
    fun setUp() {
        presenter = MuscleGroupPresenter(view, useCase, TestInteractorInvoker.create())
    }

    @Test
    fun `should show muscle groups When is happy case`() {
        var muscleGroups = getMuscleGroups()
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Right(muscleGroups))

        presenter.loadMuscleGroups()

        verify(view, times(1)).show(muscleGroups)
    }

    @Test
    fun `should show error network When is network exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.NetworkError))

        presenter.loadMuscleGroups()

        verify(view, times(1)).showNetworkError()
    }

    @Test
    fun `should show error server When is server exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Either.Left(GenericError.ServerError))

        presenter.loadMuscleGroups()

        verify(view, times(1)).showServerError()
    }

    private fun getMuscleGroups() = listOf(MuscleGroup("", ""))
}