package com.acv.gym.module.splash

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.GymApplication

import com.acv.gym.R
import com.acv.gym.di.module.SplashModule
import com.acv.gym.presentation.splash.SplashPresenter
import com.acv.gym.presentation.splash.SplashView
import com.acv.gym.ui.BaseActivity
import org.jetbrains.anko.find

import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {
    @Inject
    lateinit var presenter: SplashPresenter

    val logoApp by lazy { find<TextView>(R.id.logoApp) }

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(SplashModule(this)).inject(this)
    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun showSplash() {
        logoApp.visibility = View.VISIBLE
    }
}
