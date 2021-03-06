package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.LaunchAppLocalGatewayImpl
import com.acv.gym.data.local.Cache
import com.acv.gym.data.local.SharedPreferencesCache
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.core.InteractorInvoker
import com.acv.gym.presentation.core.InteractorInvokerImp
import com.acv.gym.presentation.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SplashModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope
    @Provides
    fun provideSplashPresenter(checkSplashUseCase: CheckSplashUseCase,
                               interactorInvoker: InteractorInvoker): SplashPresenter
            = SplashPresenter(checkSplashUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideCheckSplashUseCase(localGateway: LaunchAppLocalGateway): CheckSplashUseCase
            = CheckSplashUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLaunchAppLocalGateway(sharedPreferencesCache: Cache): LaunchAppLocalGateway
            = LaunchAppLocalGatewayImpl(sharedPreferencesCache)

    @ActivityScope
    @Provides
    fun provideCache(): Cache
            = SharedPreferencesCache(activity.applicationContext)

    @Provides @Singleton
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
