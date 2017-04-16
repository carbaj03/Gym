package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.RoutineDataSource
import com.acv.gym.data.local.*
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.usecase.splash.CheckSplashUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.routine.GetRoutineUseCase
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoutinesModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope
    @Provides
    fun provideRoutinesPresenter(useCase: GetRoutineUseCase,
                                 interactorInvoker: InteractorInvoker)
            = RoutinePresenter(useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: RoutineLocalGateway)
            = GetRoutineUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: RoutineDataSource) : RoutineLocalGateway
            = RoutineLocalGatewayImpl(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource(): RoutineDataSource = RoutineDataSourceImpl()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
