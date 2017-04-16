package com.acv.gym.di.component

import com.acv.gym.di.module.MuscleGroupModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(MuscleGroupModule::class))
interface MuscleGroupComponent {
    val presenter: MuscleGroupPresenter

    fun inject(activity: MuscleGroupActivity)
}
