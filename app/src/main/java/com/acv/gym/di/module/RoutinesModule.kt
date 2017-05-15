package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.local.RoutineLocalGatewayImpl
import com.acv.gym.data.local.datasource.RoutineLocalDataSource
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.RoutineLocalGateway
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.routine.GetRoutineUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.routine.RoutineView
import dagger.Module
import dagger.Provides

@Module
class RoutinesModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): RoutineView = activity as RoutineView

    @ActivityScope
    @Provides
    fun provideRoutinesPresenter(view: RoutineView,
                                 useCase: GetRoutineUseCase,
                                 interactorInvoker: InteractorInvoker)
            = RoutinePresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: RoutineLocalGatewayImpl)
            = GetRoutineUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: RoutineLocalDataSource)
            = RoutineLocalGatewayImpl(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource() = RoutineLocalDataSource()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
