package com.acv.gym.module.session

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class SessionActivity : BaseActivity<SessionView, SessionPresenter>(), SessionView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_session

    override fun onCreate() {
        setToolbar(R.string.session_title)
        fab.onClick { navStack<NewSessionActivity>(listOf("id" to Id("1"))) }
        loadFr<SessionFragment>(listOf("id" to getExtra()))
    }

    override fun onNewIntent() = refresh(getFr<SessionFragment>())

    override fun show(sessionExercise: List<SessionExerciseVM>) {}

    override fun showServerError() = toast("Error")

    override fun showNetworkError() = toast("Error")

    override fun showClick(id: Id) = load<SessionSetActivity>(listOf("id" to id))

    override fun enabledDeleteMode() = toast("Error")

    override fun disabledDeleteMode() = toast("Error")

    override fun goBack() = true
}