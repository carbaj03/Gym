package com.acv.gym.di.component

import com.acv.gym.di.module.RepModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.rep.RepActivity
import dagger.Subcomponent


@ActivityScope @Subcomponent(modules = arrayOf(RepModule::class))
interface RepComponent {
    fun inject(activity: RepActivity)
}
