package com.acv.gym.module.session.set

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.model.SessionSetVM
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.toast

class SessionSetActivity : BaseActivity<SessionSetView, SessionSetPresenter>() {
    override fun getLayout() = R.layout.activity_session_set

    override fun onCreate() {
        loadFr<SessionSetFragment>(listOf(extra to getExtra()))
    }
}
