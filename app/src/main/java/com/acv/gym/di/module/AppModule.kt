package com.acv.gym.di.module


import android.content.Context
import com.acv.gym.GymApplication
import com.acv.gym.ui.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: GymApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

}
