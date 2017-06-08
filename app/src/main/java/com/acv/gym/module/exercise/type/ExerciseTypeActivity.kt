package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.session.SessionFragment
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.activity_exercise_type.*
import kotlinx.android.synthetic.main.fragment_list.*

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_exercise_type

    override fun onCreate() {
        setToolbar(R.string.title_exercise_type)
        loadFr<ExerciseTypeFragment>(listOf("id" to getExtra()))
    }

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = exerciseTypes,
                listener = { presenter.checkExercise(it) },
                holder = ::ExerciseTypeViewHolder,
                layout = R.layout.item_exercise_type)
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToExercise(id: Id) = load<ExerciseActivity>(listOf("id" to id))

}
