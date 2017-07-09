package com.acv.gym.module.muscle.group

import com.acv.gym.R
import com.acv.gym.commons.extension.loadFr
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseActivity

class MuscleGroupActivity : BaseActivity<MuscleGroupView, MuscleGroupPresenter>() {
    override fun getLayout() = R.layout.activity_muscle_group

    override fun onCreate() {
        setTitle(R.string.title_muscle_group)
        loadFr<MuscleGroupFragment>()
    }
}