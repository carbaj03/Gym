package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.RoutinesDataSource
import com.acv.gym.data.local.*
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.routine.GetRoutinesUseCase
import com.acv.gym.presentation.routine.RoutinesPresenter
import com.acv.gym.presentation.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoutinesModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope
    @Provides
    fun provideRoutinesPresenter(useCase: GetRoutinesUseCase,
                               interactorInvoker: InteractorInvoker)
            = RoutinesPresenter(useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: RoutineLocalGateway)
            = GetRoutinesUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: RoutinesDataSource) : RoutineLocalGateway
            = GetRoutinesLocalGatewayImpl(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource(): RoutinesDataSource = RoutinesDataSourceImpl()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
