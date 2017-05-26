package com.acv.gym.module.exercise

import com.acv.gym.R
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.weight.WeightFragment
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVH
import katz.Option
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by alejandro on 26/05/17.
 */

class ExerciseFragment : BaseFragment<ExerciseView, ExercisePresenter>(), ExerciseView {

    override fun setupComponent() = inject()

    override fun onCreate() = presenter.loadExercises(Option(Id("1")))

    override fun getLayout() = R.layout.fragment_list

    override fun show(data: List<Exercise>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = data,
                listener = { presenter.checkExercise(it) },
                holder = ::ExercisesViewHolder,
                layout = R.layout.item_exercise)
    }

    override fun goToWeight(id: Id) = load(WeightFragment())

    override fun showNetworkError() = TODO()

    override fun showServerError() = TODO()

}