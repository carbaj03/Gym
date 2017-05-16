package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker

open class MuscleGroupPresenter(
        view: MuscleGroupView,
        val useCase: GetMuscleGroupsUseCase,
        val invoker: InteractorInvoker
) : Presenter<MuscleGroupView>(view) {
    fun loadMuscleGroups() {
        InteractorExecution(useCase)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it) }
                .execute(invoker)
    }

    private fun happyCase(muscleGroups: List<MuscleGroup>) = view.show(muscleGroups)

    private fun manageExceptions(exception: GenericExceptions) = when (exception) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }

    fun checkMuscleGroup(muscleGroup: MuscleGroup) {
        view.goToExerciseType()
    }
}