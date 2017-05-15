package com.acv.gym.module.exercise.type

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.ExerciseTypeModule
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.muscle.group.MuscleGroupAdapter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_type.*
import javax.inject.Inject

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {

    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadExerciseType()
    }

    override fun getLayout() = R.layout.activity_exercise_type

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvExerciseType) {
        layoutManager = LinearLayoutManager(context)
        adapter = ExerciseTypeAdapter(exerciseTypes) { nav<ExerciseActivity>() }
    }

    override fun showNetworkError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    override fun showServerError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

}
