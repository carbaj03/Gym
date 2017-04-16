package com.acv.gym.module.muscle.group

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.MuscleGroupModule
import com.acv.gym.di.module.SessionModule
import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.module.session.SessionAdapter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_muscle_group.*
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import javax.inject.Inject

class MuscleGroupActivity: BaseActivity(), MuscleGroupView {
    @Inject lateinit var presenter: MuscleGroupPresenter

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(MuscleGroupModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        presenter.attachView(this)
        presenter.loadMuscleGroups()
    }

    override fun getActivityLayout() = R.layout.activity_muscle_group

    override fun show(muscleGroups: List<MuscleGroupModel>) {
        rvMuscleGroup.layoutManager = LinearLayoutManager(this)
        rvMuscleGroup.adapter = MuscleGroupAdapter(muscleGroups) {
            presenter.checkMuscleGroup(it)
        }
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
