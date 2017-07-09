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

class SessionActivity : BaseActivity<SessionView, SessionPresenter>() {
    override fun getLayout() = R.layout.activity_session

    override fun onCreate() {
        setToolbar(R.string.session_title)
        fab.onClick { navStack<NewSessionActivity>(listOf(extra to Id("1"))) }
        loadFr<SessionFragment>(listOf(extra to getExtra()))
    }

    override fun onNewIntent() = refresh(getFr<SessionFragment>())
}