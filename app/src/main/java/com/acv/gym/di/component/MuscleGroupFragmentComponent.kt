package com.acv.gym.di.component

import com.acv.gym.di.module.MuscleGroupFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = arrayOf(MuscleGroupFragmentModule::class))
interface MuscleGroupFragmentComponent {
    val presenter: MuscleGroupPresenter
    fun inject(fragment: MuscleGroupFragment)
}
