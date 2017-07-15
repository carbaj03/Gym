package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>() {
    override fun getLayout() = R.layout.activity_exercise_type

    override fun onCreate() {
        setToolbar(R.string.title_exercise_type)
        loadFr<ExerciseTypeFragment>(listOf("id" to getExtra()))
    }
}
