package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.muscle.group.ViewMuscleGroup
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import dagger.Module
import dagger.Provides

@Module
class MuscleGroupModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): MuscleGroupView = activity as MuscleGroupView

    @ActivityScope @Provides
    fun providePresenter(activity: MuscleGroupView,
                         useCase: ViewMuscleGroup,
                         interactorInvoker: ServiceInvoker)
            = MuscleGroupPresenter(activity, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = ViewMuscleGroup(gateway)
}
