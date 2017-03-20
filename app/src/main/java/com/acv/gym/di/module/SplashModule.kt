package com.acv.gym.di.module


import android.app.Activity

import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.presentation.GymViewInjector
import com.acv.gym.presentation.splash.SplashPresenter

import dagger.Module
import dagger.Provides

@Module
class SplashModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope
    @Provides
    fun provideSplashPresenter(appViewInjector: GymViewInjector): SplashPresenter
            = SplashPresenter(appViewInjector)
}
