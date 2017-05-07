package com.acv.gym.module.exercise

import android.os.Bundle
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.Exercise
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.acv.gym.ui.BaseActivity


class ExerciseActivity : BaseActivity<ExerciseView, ExercisePresenter>(), ExerciseView {

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.loadExercises()
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun show(data: List<Exercise>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
