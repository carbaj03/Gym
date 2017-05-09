package com.acv.gym.di.module

import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.presentation.module.weight.WeightPresenter
import com.acv.gym.presentation.module.weight.WeightView
import dagger.Module
import dagger.Provides


@Module
class WeightModule(activity: Activity) : ActivityModule(activity) {
    @ActivityScope @Provides
    fun provideView(): WeightView = activity as WeightView

    @ActivityScope
    @Provides
    fun providePresenter(view: WeightView) = WeightPresenter(view)

}