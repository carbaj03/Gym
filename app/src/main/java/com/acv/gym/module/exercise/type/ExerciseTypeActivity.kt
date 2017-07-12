package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.service.Id
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.session.SessionFragment
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.activity_exercise_type.*
import kotlinx.android.synthetic.main.fragment_list.*

class ExerciseTypeActivity : BaseActivity<ExerciseTypeView, ExerciseTypePresenter>() {
    override fun getLayout() = R.layout.activity_exercise_type

    override fun onCreate() {
        setToolbar(R.string.title_exercise_type)
        loadFr<ExerciseTypeFragment>(listOf("id" to getExtra()))
    }
}
