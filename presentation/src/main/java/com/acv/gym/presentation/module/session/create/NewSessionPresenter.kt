package com.acv.gym.presentation.module.session.create

import com.acv.gym.domain.GenericError
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.ExerciseCommand
import com.acv.gym.domain.service.Id
import com.acv.gym.domain.service.NewSessionCommand
import com.acv.gym.domain.service.session.AddSessionExercise
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.invoker.UseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.invoker.invoke
import kategory.Option


open class NewSessionPresenter(
        view: NewSessionView,
        val useCase: AddSessionExercise,
        val invoker: UseCaseInvoker
) : Presenter<NewSessionView>(view) {

    private lateinit var session: SessionExercise
    private lateinit var sets: List<Set>
    private lateinit var sessionSet: Set
    private lateinit var idMuscleGroup: Id

    fun persist() = invoker invoke UseCase(
            interactor = useCase,
            params = Option(NewSessionCommand(listOf(session))),
            result = { happyCase() },
            error = { manageExceptions(it) }
    )

    private fun happyCase() = view.showSuccess()

    private fun manageExceptions(exceptions: GenericError) = when (exceptions) {
        GenericError.NetworkError -> view.showNetworkError()
        GenericError.ServerError -> view.showServerError()
    }

    fun checkExercise(id: Id) {
        session = session.copy(exercise = Exercise(id.value, "", "", ""))
        view.goToWeight()
    }

    fun checkWeight(num: Float) {
        sessionSet = Set(weight = num, sessionExercise = Id(session.id.value))
        view.goToReps()
        view.showFab()
    }

    fun checkRep(num: Int) {
        sessionSet = sessionSet.copy(reps = num)
        sets = sets.plus(sessionSet)
        session = session.copy(sets = sets)
        view.goToReps()
    }

    fun checkSession(id: Option<Id>) {
        session = when (id) {
            is Option.None -> SessionExercise()
            is Option.Some -> SessionExercise(session = id.value)
        }
        sets = listOf()
    }

    fun checkMuscleGroup(id: Id) {
        idMuscleGroup = id
        view.goToExerciseType(id)
    }

    fun checkExerciseType(idExerciseType: Id) =
            view.goToExercise(ExerciseCommand(idMuscleGroup, idExerciseType))
}
