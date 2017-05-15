package com.acv.gym.module.session

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.SessionModule
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import javax.inject.Inject

class SessionActivity : BaseActivity<SessionView, SessionPresenter>(), SessionView {
    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadSessions()
        fab.onClick { nav<MuscleGroupActivity>() }
    }

    override fun getLayout() = R.layout.activity_session

    override fun show(sessionExercise: List<SessionExercise>) {
        rvSession.layoutManager = LinearLayoutManager(this)
        rvSession.adapter = SessionAdapter(sessionExercise) { presenter.checkExercise(it) }
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
