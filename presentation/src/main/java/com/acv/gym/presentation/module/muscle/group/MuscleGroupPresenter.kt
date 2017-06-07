package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Interactor
import com.acv.gym.presentation.invoker.InteractorInvoker

open class MuscleGroupPresenter(
        view: MuscleGroupView,
        val useCase: GetMuscleGroupsUseCase,
        val invoker: InteractorInvoker
) : Presenter<MuscleGroupView>(view) {
    fun loadMuscleGroups() =
            Interactor(
                    interactor = useCase,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(muscleGroups: List<MuscleGroup>) = view.show(muscleGroups)

    private fun manageExceptions(exception: GenericError) = when (exception) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkMuscleGroup(muscleGroup: MuscleGroup) = view.goToExerciseType(Id(muscleGroup.id))

}