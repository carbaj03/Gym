package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.nav
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_type.*

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_exercise_type

    override fun createView() = presenter.loadExerciseType()

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvExerciseType) {
        layoutManager = gridLayoutManager()
        adapter = ExerciseTypeAdapter(exerciseTypes) { nav<ExerciseActivity>(listOf()) }
    }

    override fun showNetworkError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    override fun showServerError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

}
