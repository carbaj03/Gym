package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.presentation.Id
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.activity_exercise_type.*

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_exercise_type

    override fun createView() {
        setTitle(R.string.title_exercise_type)
        presenter.loadExerciseType(getId())
    }

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvExerciseType) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = exerciseTypes,
                listener = { presenter.checkExercise(it)},
                holder = ::ExerciseTypeViewHolder,
                layout = R.layout.item_exercise_type)
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToExercise(id: Id) = nav<ExerciseActivity>(listOf("id" to id))

}
