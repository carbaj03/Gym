package com.acv.gym.di.module


import android.app.Activity

import com.acv.gym.ui.customview.spinner.SpinnerLoading
import com.acv.gym.ui.customview.spinner.SpinnerLoadingImp

import dagger.Module
import dagger.Provides

@Module
open class ActivityModule(val activity: Activity) {

    @Provides fun provideActivity(): Activity  = activity

    @Provides fun provideSpinnerLoading(): SpinnerLoading = SpinnerLoadingImp(activity)
}
