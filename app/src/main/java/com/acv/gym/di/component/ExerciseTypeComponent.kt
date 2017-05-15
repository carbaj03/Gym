package com.acv.gym.di.component

import com.acv.gym.di.module.ExerciseTypeModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(ExerciseTypeModule::class))
interface ExerciseTypeComponent {
    fun inject(activity: ExerciseTypeActivity)

    val presenter: ExerciseTypePresenter
}
