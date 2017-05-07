package com.acv.gym.module.splash

import android.os.Bundle
import android.view.View
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.SplashModule
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadSplash()

        logoApp.setOnClickListener { nav<SessionActivity>() }
    }

    override fun getLayout() = R.layout.activity_splash

    override fun show(data: List<Any>) {
        logoApp.visibility = View.VISIBLE
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
