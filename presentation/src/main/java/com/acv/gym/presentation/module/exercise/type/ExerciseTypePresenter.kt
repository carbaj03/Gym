package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.Id
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option

class ExerciseTypePresenter(
        view: ExerciseTypeView,
        val useCase: GetExerciseTypesUseCase,
        val invoker: InteractorInvoker
) : Presenter<ExerciseTypeView>(view) {

    fun loadExerciseType(id: Id) =
        InteractorExecution(
                interactor = useCase,
                params = Option(id),
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