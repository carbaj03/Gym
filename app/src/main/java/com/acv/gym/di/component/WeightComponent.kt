package com.acv.gym.di.component

import com.acv.gym.di.module.WeightModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.weight.WeightActivity
import dagger.Subcomponent

@ActivityScope @Subcomponent(modules = arrayOf(WeightModule::class))
interface WeightComponent {
    fun inject(activity: WeightActivity)
}
