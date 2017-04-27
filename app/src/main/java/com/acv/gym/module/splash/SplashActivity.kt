package com.acv.gym.module.splash

import android.os.Bundle
import android.view.View
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.extension.nav
import com.acv.gym.di.module.SplashModule
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {
    @Inject lateinit var presenter: SplashPresenter

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(SplashModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadSplash()

        logoApp.setOnClickListener { nav<SessionActivity>() }
    }

    override fun getActivityLayout() = R.layout.activity_splash

    override fun showSplash() {
        logoApp.visibility = View.VISIBLE
    }

    override fun renderNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
