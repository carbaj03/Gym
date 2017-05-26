package com.acv.gym.module.session

import com.acv.gym.R
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.commons.extension.navStack
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import katz.Option
import kotlinx.android.synthetic.main.activity_session.*
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class SessionActivity : BaseActivity<SessionView, SessionPresenter>(), SessionView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_session

    override fun onCreate() {
        setTitle(R.string.session_title)
        presenter.loadSessions(Option.None)
        fab.onClick { navStack<NewSessionActivity>() }
        load(SessionFragment())
    }

    override fun show(sessionExercise: List<SessionExercise>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = sessionExercise,
                listener = { presenter.checkExercise(it) },
                holder = ::SessionViewHolder,
                layout = R.layout.item_session)
    }

    override fun showServerError() = toast("Error")

    override fun showNetworkError() = TODO("not implemented")

    override fun showClick() = toast("Click")
}
