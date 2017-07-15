package com.acv.gym.module.exercise

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import com.acv.gym.ui.BaseActivity


class ExerciseActivity : BaseActivity<ExerciseView, ExercisePresenter>() {
    override fun getLayout() = R.layout.activity_exercise

    override fun onCreate() {
        setTitle(R.string.title_exercise)
        presenter.loadExercises(getId())
    }
}
