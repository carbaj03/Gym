package com.acv.gym.module.session

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.ExerciseFragment
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.rep.RepFragment
import com.acv.gym.module.weight.WeightFragment
import com.acv.gym.presentation.module.session.NewSessionPresenter
import com.acv.gym.presentation.module.session.NewSessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

sealed class Nav
data class MuscleGroupNav(val id: Id) : Nav()
data class ExerciseTypeNav(val id: Id) : Nav()
data class ExerciseNav(val id: Id) : Nav()
data class WeightNav(val num: Int) : Nav()
data class RepNav(val num: Int) : Nav()

class NewSessionActivity : BaseActivity<NewSessionView, NewSessionPresenter>(), NewSessionView {
    override fun onCreate() = loadFra<MuscleGroupFragment>()

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_new_session

    override fun showSuccess() = toast("Insertado con éxito")

    override fun showServerError() {
        TODO("not implemented")
    }

    override fun showNetworkError() {
        TODO("not implemented")
    }

    fun loadFr(f: Nav) = when (f) {
        is MuscleGroupNav -> loadFra<ExerciseTypeFragment>()
        is ExerciseTypeNav -> loadFra<ExerciseFragment>(listOf("id" to f.id))
        is ExerciseNav -> loadFra<WeightFragment>()
        is WeightNav -> {
            loadFra<RepFragment>()
            fab.visible()
            fab.onClick { navStack<NewSessionActivity>() }
        }
        is RepNav -> toast("save")
    }
}