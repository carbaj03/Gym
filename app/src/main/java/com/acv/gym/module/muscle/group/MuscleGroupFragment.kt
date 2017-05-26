package com.acv.gym.module.muscle.group

import com.acv.gym.R
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.fragment_list.*


class MuscleGroupFragment : BaseFragment<MuscleGroupView, MuscleGroupPresenter>(), MuscleGroupView {
    override fun setupComponent() = inject()

    override fun onCreate() = presenter.loadMuscleGroups()

    override fun getLayout() = R.layout.fragment_list

    override fun show(muscleGroups: List<MuscleGroup>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = muscleGroups,
                listener = { presenter.checkMuscleGroup(it) },
                holder = ::MuscleGroupViewHolder,
                layout = R.layout.item_muscle_group)
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToExerciseType(id: String) = load(ExerciseTypeFragment())
}
