package com.acv.gym.di.component


import com.acv.gym.di.module.*
import com.acv.gym.module.rep.RepFragment
import com.acv.gym.module.session.SessionFragment
import com.acv.gym.module.session.set.SessionSetFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class
))
interface AppComponent {
    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: SessionModule): SessionComponent
    operator fun plus(module: NewSessionModule): NewSessionComponent
    operator fun plus(module: SessionFragmentModule): SessionFragmentComponent
    operator fun plus(module: MuscleGroupModule): MuscleGroupComponent
    operator fun plus(module: MuscleGroupFragmentModule): MuscleGroupFragmentComponent
    operator fun plus(module: ExerciseTypeModule): ExerciseTypeComponent
    operator fun plus(module: ExerciseTypeFragmentModule): ExerciseTypeFragmentComponent
    operator fun plus(module: ExerciseModule): ExerciseComponent
    operator fun plus(module: ExerciseFragmentModule): ExerciseFragmentComponent
    operator fun plus(module: WeightModule): WeightComponent
    operator fun plus(module: WeightFragmentModule): WeightFragmentComponent
    operator fun plus(module: RepModule): RepComponent
    operator fun plus(module: RepFragmentModule): RepFragmentComponent
    operator fun plus(module: SessionSetModule): SessionSetComponent
    operator fun plus(module: SessionSetFragmentModule): SessionSetFragmentComponent
}
