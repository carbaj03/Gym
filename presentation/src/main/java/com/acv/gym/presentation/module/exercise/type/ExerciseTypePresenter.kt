package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.EmptyCommand
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker

class ExerciseTypePresenter(view: ExerciseTypeView,
                            val useCase: GetExerciseTypesUseCase,
                            val invoker: InteractorInvoker) : Presenter<ExerciseTypeView>(view) {
    fun loadExerciseType(command: Command = EmptyCommand()) {
        InteractorExecution(useCase, command)
                .result { happyCase(it) }
                .execute(invoker)
    }

    private fun happyCase(it: List<ExerciseTypeModel>) = view.show(it)
}