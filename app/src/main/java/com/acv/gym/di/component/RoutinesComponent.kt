package com.acv.gym.di.component

import com.acv.gym.di.module.RoutinesModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.presentation.module.routine.RoutinePresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(RoutinesModule::class))
interface RoutinesComponent {
    fun inject(activity: RoutineActivity)

    val presenter: RoutinePresenter
}
