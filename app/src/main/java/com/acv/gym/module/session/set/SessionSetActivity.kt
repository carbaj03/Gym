package com.acv.gym.module.session.set

import com.acv.gym.R
import com.acv.gym.commons.extension.getId
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_session_set.*
import org.jetbrains.anko.toast

class SessionSetActivity : BaseActivity<SessionSetView, SessionSetPresenter>(), SessionSetView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_session_set

    override fun onCreate() {
        presenter.loadSessionSet(getId())
    }

    override fun show(data: List<SessionSet>) {
        data.map {
            logoApp.text = it.sessionExercise
        }
    }

    override fun showNetworkError() = toast("Error")

    override fun showServerError() = toast("Error")
}
