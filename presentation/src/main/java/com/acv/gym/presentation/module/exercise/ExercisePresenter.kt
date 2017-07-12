package com.acv.gym.presentation.module.exercise

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.exercise.ViewAllExercise
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.Logic
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.acv.gym.presentation.invoker.invoke
import kategory.Option


open class ExercisePresenter(
        view: ExerciseView,
        val useCase: ViewAllExercise,
        val invoker: ServiceInvoker
) : Presenter<ExerciseView>(view) {

    fun loadExercises(params: Option<ExerciseCommand>) = invoker invoke Logic(
            params = params,
            service = useCase,
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