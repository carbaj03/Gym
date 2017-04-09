package com.acv.gym.di.component

import com.acv.gym.di.module.RoutinesModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.routines.RoutinesActivity
import com.acv.gym.presentation.routine.RoutinesPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(RoutinesModule::class))
interface RoutinesComponent {
    fun inject(activity: RoutinesActivity)

    val presenter: RoutinesPresenter
}
