package com.acv.gym.presentation.module.muscle.group

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.muscle.group.ViewMuscleGroup
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker

open class MuscleGroupPresenter(
        view: MuscleGroupView,
        val useCase: ViewMuscleGroup,
        val invoker: ServiceInvoker
) : Presenter<MuscleGroupView>(view) {
    fun loadMuscleGroups() =
            Logic(
                    service = useCase,
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