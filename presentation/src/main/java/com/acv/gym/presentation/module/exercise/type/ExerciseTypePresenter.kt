package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.service.ExerciseTypeCommand
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.exercise.type.ViewExerciseType
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker
import kategory.Option

class ExerciseTypePresenter(
        view: ExerciseTypeView,
        val useCase: ViewExerciseType,
        val invoker: ServiceInvoker
) : Presenter<ExerciseTypeView>(view) {

    fun loadExerciseType(id: Option<Id>) =
            Logic(
                    service = useCase,
                    params = id.map(::ExerciseTypeCommand),
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)

    private fun happyCase(exerciseTypes: List<ExerciseType>) = view.show(exerciseTypes)

    private fun manageExceptions(exception: GenericError) = when (exception) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(exerciseType: ExerciseType) = view.goToExercise(Id(exerciseType.id))
}