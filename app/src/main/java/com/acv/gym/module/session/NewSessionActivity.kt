package com.acv.gym.module.session

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.usecase.ExerciseCommand
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.ExerciseFragment
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.rep.RepFragment
import com.acv.gym.module.weight.WeightFragment
import com.acv.gym.presentation.module.session.create.NewSessionPresenter
import com.acv.gym.presentation.module.session.create.NewSessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

sealed class Nav
data class MuscleGroupNav(val id: Id) : Nav()
data class ExerciseTypeNav(val id: Id) : Nav()
data class ExerciseNav(val id: Id) : Nav()
data class WeightNav(val num: Float) : Nav()
data class RepNav(val num: Int) : Nav()

class NewSessionActivity : BaseActivity<NewSessionView, NewSessionPresenter>(), NewSessionView {
    override fun onCreate() {
        loadFr<MuscleGroupFragment>()
        presenter.checkSession(getId())
    }

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_new_session

    override fun showSuccess() {
        toast("Insertado con éxito")
        nav<SessionActivity>(listOf("id" to Id("1")))
    }

    override fun showServerError() = toast("error server")

    override fun showNetworkError() = toast("error network")

    override fun done(nav: Nav) = when (nav) {
        is MuscleGroupNav -> presenter.checkMuscleGroup(nav.id)
        is ExerciseTypeNav -> presenter.checkExerciseType(nav.id)
        is ExerciseNav -> presenter.checkExercise(nav.id)
        is WeightNav -> presenter.checkWeight(nav.num)
        is RepNav -> {
            presenter.checkRep(nav.num)
            presenter.persist()
        }
    }

    override fun goToExerciseType(id: Id) =
            loadFr<ExerciseTypeFragment>(listOf(extra to id))

    override fun goToExercise(exerciseCommand: ExerciseCommand) =
            loadFr<ExerciseFragment>(listOf(extra to exerciseCommand))

    override fun goToWeight() = loadFr<WeightFragment>()

    override fun goToReps() = loadFr<RepFragment>()

    override fun showFab() {
        fab.visible()
        fab.onClick { presenter.checkRep(getFr<RepFragment>().value().num) }
    }
}
