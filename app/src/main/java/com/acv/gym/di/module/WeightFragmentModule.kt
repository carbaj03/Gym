package com.acv.gym.di.module

import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.presentation.module.weight.WeightPresenter
import com.acv.gym.presentation.module.weight.WeightView
import dagger.Module
import dagger.Provides


@Module
class WeightFragmentModule(fragment: Fragment) : FragmentModule(fragment) {
    @FragmentScope @Provides
    fun provideView(): WeightView = fragment as WeightView

    @FragmentScope
    @Provides
    fun providePresenter(view: WeightView) = WeightPresenter(view)

}