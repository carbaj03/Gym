package com.acv.gym.presentation.splash

import com.acv.gym.presentation.View

interface SplashView : View {
    fun showSplash()
    fun renderNetworkError()
    fun renderServerError()
}
