package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.muscle.group.MuscleGroupViewHolder
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.activity_exercise_type.*
import kotlinx.android.synthetic.main.fragment_list.*


class ExerciseTypeFragment : BaseFragment<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {
    override fun setupComponent() = inject()

    override fun onCreate() = presenter.loadExerciseType(Id(""))

    override fun getLayout() = R.layout.fragment_list

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = exerciseTypes,
                listener = { presenter.checkExercise(it) },
                holder = ::ExerciseTypeViewHolder,
                layout = com.acv.gym.R.layout.item_exercise_type)
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToExercise(id: Id) = nav<ExerciseActivity>(listOf("id" to id))
}
