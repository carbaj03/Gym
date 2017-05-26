package com.acv.gym.module.session

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.presentation.module.session.NewSessionPresenter
import com.acv.gym.presentation.module.session.NewSessionView
import com.acv.gym.ui.BaseActivity
import org.jetbrains.anko.toast


class NewSessionActivity : BaseActivity<NewSessionView, NewSessionPresenter>(), NewSessionView {
    override fun onCreate() = load(MuscleGroupFragment())

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_new_session

    override fun showSuccess() = toast("Insertado con éxito")

    override fun showServerError() {
        TODO("not implemented")
    }

    override fun showNetworkError() {
        TODO("not implemented")
    }

}