package com.acv.gym.module.splash

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.commons.extension.visible
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_splash

    override fun createView() {
        presenter.loadSplash()
        logoApp.setOnClickListener { nav<SessionActivity>(listOf()) }
    }

    override fun show(data: List<Any>) = logoApp.visible()

    override fun showNetworkError() = TODO()

    override fun showServerError() = TODO()
}
