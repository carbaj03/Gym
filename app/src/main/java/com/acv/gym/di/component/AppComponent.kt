package com.acv.gym.di.component


import com.acv.gym.di.module.AppModule
import com.acv.gym.di.module.SplashModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    operator fun plus(module: SplashModule): SplashComponent
}
