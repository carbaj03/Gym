package com.acv.gym.module.muscle.group

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseActivity

class MuscleGroupActivity : BaseActivity<MuscleGroupView, MuscleGroupPresenter>(), MuscleGroupView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_muscle_group

    override fun createView() {
        setTitle(R.string.title_muscle_group)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MuscleGroupFragment())
                .commit()
    }

    override fun showNetworkError() {
        TODO("not implemented")
    }

    override fun showServerError() {
        TODO("not implemented")
    }

    override fun show(data: List<MuscleGroup>) {
        TODO("not implemented")
    }

    override fun goToExerciseType(id: String) {
        TODO("not implemented")
    }
}