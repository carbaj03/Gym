package com.acv.gym.di.component

import com.acv.gym.di.module.WeightFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.weight.WeightFragment
import dagger.Subcomponent

@FragmentScope @Subcomponent(modules = arrayOf(WeightFragmentModule::class))
interface WeightFragmentComponent {
    fun inject(fragment: WeightFragment)
}
