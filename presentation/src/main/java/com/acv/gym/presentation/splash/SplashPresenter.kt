package com.acv.gym.presentation.splash

import com.acv.gym.presentation.GymViewInjector
import com.acv.gym.presentation.Presenter


open class SplashPresenter(viewInjector: GymViewInjector) : Presenter<SplashView>(viewInjector) {

    override fun onViewAttached() {
        view?.showSplash()
    }
}