package com.acv.gym.module.exercise

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.nav
import com.acv.gym.domain.model.Exercise
import com.acv.gym.module.weight.WeightActivity
import com.acv.gym.presentation.Id
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.activity_exercise.*


class ExerciseActivity : BaseActivity<ExerciseView, ExercisePresenter>(), ExerciseView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_exercise

    override fun createView() {
        setTitle(R.string.title_exercise)
        presenter.loadExercises(getId())
    }

    override fun show(data: List<Exercise>) = with(rvExercise) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = data,
                listener = { presenter.checkExercise(it) },
                holder = ::ExercisesViewHolder,
                layout = R.layout.item_exercise)
    }

    override fun goToWeight(id: Id) = nav<WeightActivity>(listOf())

    override fun showNetworkError() = TODO()

    override fun showServerError() = TODO()

}
