package com.acv.gym.module.muscle.group

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.commons.extension.loadFr
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseActivity

class MuscleGroupActivity : BaseActivity<MuscleGroupView, MuscleGroupPresenter>(), MuscleGroupView {
    override fun goToExerciseType(id: Id) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_muscle_group

    override fun onCreate() {
        setTitle(R.string.title_muscle_group)
        loadFr<MuscleGroupFragment>()
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
}