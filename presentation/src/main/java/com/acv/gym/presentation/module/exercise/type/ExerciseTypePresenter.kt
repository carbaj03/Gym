package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker

class ExerciseTypePresenter(view: ExerciseTypeView,
                            val useCase: GetExerciseTypesUseCase,
                            val invoker: InteractorInvoker) : Presenter<ExerciseTypeView>(view) {
    fun loadExerciseType() {
        InteractorExecution(useCase)
                .result { happyCase(it) }
                .errorResult { manageExceptions(it)}
                .execute(invoker)
    }

    private fun happyCase(exerciseTypes: List<ExerciseType>) = view.show(exerciseTypes)

    private fun manageExceptions(exception: GenericExceptions) = when (exception) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }
}