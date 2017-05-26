package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.exercise.GetExercisesUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker
import katz.Option


open class ExercisePresenter(
        view: ExerciseView,
        val useCase: GetExercisesUseCase,
        val invoker: InteractorInvoker
) : Presenter<ExerciseView>(view) {

    fun loadExercises(id: Option<Id> = Option.None) =
            InteractorExecution(
                    params = id.map { ExerciseCommand(it.value) },
                    interactor = useCase,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)


    private fun happyCase(exercises: List<Exercise>) = view.show(exercises)

    private fun manageExceptions(exception: GenericError) = when (exception) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(exercise: Exercise) = view.goToWeight(Id(exercise.id))
}