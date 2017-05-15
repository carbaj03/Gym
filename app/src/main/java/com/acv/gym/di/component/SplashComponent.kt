package com.acv.gym.di.component

import com.acv.gym.di.module.SplashModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.splash.SplashActivity
import com.acv.gym.presentation.module.splash.SplashPresenter

import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SplashModule::class))
interface SplashComponent {
    fun inject(activity: SplashActivity)

    val splashPresenter: SplashPresenter
}
