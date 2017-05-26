package com.acv.gym.di.component

import com.acv.gym.di.module.RepFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.rep.RepFragment
import dagger.Subcomponent


@FragmentScope @Subcomponent(modules = arrayOf(RepFragmentModule::class))
interface RepFragmentComponent {
    fun inject(fragment: RepFragment)
}
