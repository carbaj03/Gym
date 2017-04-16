package com.acv.gym.module.session

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.SessionModule
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import javax.inject.Inject

class SessionActivity : BaseActivity(), SessionView {
    @Inject lateinit var presenter: SessionPresenter

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(SessionModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.loadSessions()
        fab.onClick { nav<MuscleGroupActivity>() }
    }

    override fun getActivityLayout() = R.layout.activity_session

    override fun show(sessionExercise: List<SessionExerciseModel>) {
        rvSession.layoutManager = LinearLayoutManager(this)
        rvSession.adapter = SessionAdapter(sessionExercise) {
            presenter.checkExercise(it)
        }
    }

    override fun renderNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
