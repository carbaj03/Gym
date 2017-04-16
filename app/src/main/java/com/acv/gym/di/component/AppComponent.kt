package com.acv.gym.di.component


import com.acv.gym.di.module.*
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: RoutinesModule): RoutinesComponent
    operator fun plus(module: SessionModule): SessionComponent
    operator fun plus(module: MuscleGroupModule): MuscleGroupComponent
}
