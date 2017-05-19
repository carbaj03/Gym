package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.exercise.GetExercisesUseCase
import com.acv.gym.presentation.Id
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.InteractorExecution
import com.acv.gym.presentation.invoker.InteractorInvoker


open class ExercisePresenter(
        view: ExerciseView,
        val useCase: GetExercisesUseCase,
        val invoker: InteractorInvoker
) : Presenter<ExerciseView>(view) {

    fun loadExercises(id: Id) =
            InteractorExecution(
                    interactor = useCase,
                    result = { happyCase(it) },
                    error = { manageExceptions(it) }
            ).execute(invoker)


    private fun happyCase(exercises: List<Exercise>) = view.show(exercises)

    private fun manageExceptions(exception: GenericExceptions) = when (exception) {
        is GenericExceptions.NetworkError -> view.showNetworkError()
        is GenericExceptions.ServerError -> view.showServerError()
    }

    fun checkExercise(exercise: Exercise) = view.goToWeight(Id(exercise.id))
}