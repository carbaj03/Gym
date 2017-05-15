package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.local.Cache
import com.acv.gym.data.local.SharedPreferencesCache
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import dagger.Module
import dagger.Provides

@Module
class SplashModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): SplashView = activity as SplashView

    @ActivityScope
    @Provides
    fun provideSplashPresenter(view: SplashView,
                               checkSplashUseCase: CheckSplashUseCase,
                               interactorInvoker: InteractorInvoker): SplashPresenter
            = SplashPresenter(view, checkSplashUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideCheckSplashUseCase(localGateway: com.acv.gym.domain.gateway.LaunchAppGateway): CheckSplashUseCase
            = CheckSplashUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLaunchAppLocalGateway(sharedPreferencesCache: Cache): com.acv.gym.domain.gateway.LaunchAppGateway
            = com.acv.gym.data.local.LaunchAppLocalGateway(sharedPreferencesCache)

    @ActivityScope
    @Provides
    fun provideCache(): Cache
            = SharedPreferencesCache(activity.applicationContext)

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
