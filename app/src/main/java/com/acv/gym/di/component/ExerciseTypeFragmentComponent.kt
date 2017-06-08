package com.acv.gym.di.component

import com.acv.gym.di.module.ExerciseTypeFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = arrayOf(ExerciseTypeFragmentModule::class))
interface ExerciseTypeFragmentComponent {
    fun inject(fragment: ExerciseTypeFragment)

    val presenter: ExerciseTypePresenter
}
