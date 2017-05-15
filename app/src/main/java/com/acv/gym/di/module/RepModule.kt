package com.acv.gym.di.module

import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import dagger.Module
import dagger.Provides


@Module
class RepModule(activity: Activity) : ActivityModule(activity) {
    @ActivityScope @Provides
    fun provideView(): RepView = activity as RepView

    @ActivityScope
    @Provides
    fun providePresenter(view: RepView) = RepPresenter(view)

}