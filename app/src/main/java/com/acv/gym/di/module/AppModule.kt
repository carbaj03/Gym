package com.acv.gym.di.module


import android.content.Context
import com.acv.gym.GymApplication
import com.acv.gym.commons.outputs.MainThreadSpec
import com.acv.gym.di.qualifier.UiThread
import com.acv.gym.presentation.GymViewInjector
import com.acv.gym.presentation.ViewInjectorImp
import com.acv.gym.ui.navigation.Navigator
import dagger.Module
import dagger.Provides
import me.panavtec.threaddecoratedview.views.ThreadSpec
import javax.inject.Singleton

@Module
class AppModule(private val application: GymApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

    @Provides
    @Singleton
    @UiThread
    fun provideMainThread(): ThreadSpec = MainThreadSpec()

    @Provides
    @Singleton
    fun provideAppViewInjector(@UiThread threadSpec: ThreadSpec): GymViewInjector
            = ViewInjectorImp(threadSpec)
}
