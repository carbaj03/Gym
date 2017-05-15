package com.acv.gym.module.session

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.navStack
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick

class SessionActivity : BaseActivity<SessionView, SessionPresenter>(), SessionView {
    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadSessions()
        fab.onClick { navStack<MuscleGroupActivity>() }
    }

    override fun getLayout() = R.layout.activity_session

    override fun show(sessionExercise: List<SessionExercise>) = with(rvSession) {
        layoutManager = LinearLayoutManager(applicationContext)
        adapter = SessionAdapter(sessionExercise) { presenter.checkExercise(it) }
    }

    override fun showServerError() =
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    override fun showNetworkError() =
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
