package com.acv.gym.di.module

import android.support.v4.app.Fragment
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import dagger.Module
import dagger.Provides


@Module
class RepFragmentModule(fragment: Fragment) : FragmentModule(fragment) {
    @FragmentScope @Provides
    fun provideView(): RepView = fragment as RepView

    @FragmentScope
    @Provides
    fun providePresenter(view: RepView) = RepPresenter(view)

}