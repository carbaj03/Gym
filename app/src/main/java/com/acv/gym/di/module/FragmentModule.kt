package com.acv.gym.di.module


import android.app.Activity
import android.support.v4.app.Fragment

import com.acv.gym.ui.customview.spinner.SpinnerLoading
import com.acv.gym.ui.customview.spinner.SpinnerLoadingImp

import dagger.Module
import dagger.Provides

@Module
open class FragmentModule(val fragment: Fragment) {

    @Provides fun provideFragment(): Fragment = fragment

    @Provides fun provideSpinnerLoading(): SpinnerLoading = SpinnerLoadingImp(fragment.context)
}
