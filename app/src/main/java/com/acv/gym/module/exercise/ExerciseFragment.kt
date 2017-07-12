package com.acv.gym.module.exercise

import android.widget.Toast
import com.acv.gym.R
import com.acv.gym.commons.extension.done
import com.acv.gym.commons.extension.getArgId
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.service.Id
import com.acv.gym.module.session.ExerciseNav
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.fragment_list.*


class ExerciseFragment : BaseFragment<ExerciseView, ExercisePresenter>(), ExerciseView {
    override fun setupComponent() = inject()

    override fun onCreate() = presenter.loadExercises(getArgId())

    override fun getLayout() = R.layout.fragment_list

    override fun show(data: List<Exercise>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = data,
                listener = { presenter.checkExercise(it) },
                holder = ::ExercisesViewHolder,
                layout = R.layout.item_exercise)
    }

    override fun goToWeight(id: Id) = done(ExerciseNav(id))

    override fun showNetworkError() = Toast.makeText(context, "error", Toast.LENGTH_LONG).show()

    override fun showServerError() = Toast.makeText(context, "error", Toast.LENGTH_LONG).show()

}