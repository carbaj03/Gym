package com.acv.gym.module.muscle.group

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.nav
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.model.Id
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_muscle_group.*

class MuscleGroupActivity : BaseActivity<MuscleGroupView, MuscleGroupPresenter>(), MuscleGroupView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_muscle_group

    override fun createView() = presenter.loadMuscleGroups()

    override fun show(muscleGroups: List<MuscleGroup>) = with(rvMuscleGroup) {
        layoutManager = gridLayoutManager()
        adapter = MuscleGroupAdapter(muscleGroups) {
            presenter.checkMuscleGroup(it)
        }
    }

    override fun showNetworkError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    override fun showServerError() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    override fun goToExerciseType() = nav<ExerciseTypeActivity>(listOf("" to Id("")))

}
