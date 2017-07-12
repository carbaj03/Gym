package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.routine.GetRoutineUseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
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
    fun provideRoutinesPresenter(
            view: RoutineView,
            useCase: GetRoutineUseCase,
            interactorInvoker: UseCaseInvoker
    ) = RoutinePresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: GymGateway) = GetRoutineUseCase(localGateway)
}
