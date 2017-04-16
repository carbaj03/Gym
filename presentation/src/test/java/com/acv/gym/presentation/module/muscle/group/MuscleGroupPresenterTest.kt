package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.presentation.module.splash.TestInteractorInvoker
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.funktionale.either.Disjunction
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
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.right(muscleGroups))

        presenter.loadMuscleGroups()

        verify(view, times(1)).show(muscleGroups)
    }

    @Test
    fun `should show error network When is network exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.left(GenericExceptions.NetworkError()))

        presenter.loadMuscleGroups()

        verify(view, times(1)).showNetworkError()
    }

    @Test
    fun `should show error Server When is server exception`() {
        Mockito.`when`(useCase.execute(any())).thenReturn(Disjunction.left(GenericExceptions.ServerError()))

        presenter.loadMuscleGroups()

        verify(view, times(1)).showServerError()
    }

    private fun getMuscleGroups() = listOf<MuscleGroupModel>(MuscleGroupModel("", ""))
}