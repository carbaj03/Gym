package com.acv.gym.di.component

import com.acv.gym.di.module.ExerciseFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.exercise.ExerciseFragment
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = arrayOf(ExerciseFragmentModule::class))
interface ExerciseFragmentComponent {
    fun inject(fragment: ExerciseFragment)
    val presenter: ExercisePresenter
}
