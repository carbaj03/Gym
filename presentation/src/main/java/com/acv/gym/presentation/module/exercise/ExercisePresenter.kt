package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.exercise.GetExercisesUseCase
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.invoker.invoke
import katz.Option


open class ExercisePresenter(
        view: ExerciseView,
        val useCase: GetExercisesUseCase,
        val invoker: UseCaseInvoker
) : Presenter<ExerciseView>(view) {

    fun loadExercises(params: Option<ExerciseCommand>) = invoker invoke UseCase(
            params = params,
            interactor = useCase,
            result = { happyCase(it) },
            error = { manageExceptions(it) }
    )

    private fun happyCase(exercises: List<Exercise>) = view.show(exercises)

    private fun manageExceptions(exception: GenericError) = when (exception) {
        is GenericError.NetworkError -> view.showNetworkError()
        is GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(exercise: Exercise) = view.goToWeight(Id(exercise.id))
}