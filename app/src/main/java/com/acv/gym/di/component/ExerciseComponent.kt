package com.acv.gym.di.component

import com.acv.gym.di.module.ExerciseModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(ExerciseModule::class))
interface ExerciseComponent {
    fun inject(activity: ExerciseActivity)

    val presenter: ExercisePresenter
}
