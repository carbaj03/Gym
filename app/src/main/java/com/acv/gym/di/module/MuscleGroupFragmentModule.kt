package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.muscle.group.ViewMuscleGroup
import com.acv.gym.presentation.invoker.ServiceInvoker
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import com.acv.gym.presentation.module.muscle.group.MuscleGroupView
import dagger.Module
import dagger.Provides

@Module
class MuscleGroupFragmentModule(fragment: Fragment) : FragmentModule(fragment) {

    @FragmentScope @Provides
    fun provideView(): MuscleGroupView = fragment as MuscleGroupView

    @FragmentScope @Provides
    fun providePresenter(
            activity: MuscleGroupView,
            useCase: ViewMuscleGroup,
            interactorInvoker: ServiceInvoker
    ) = MuscleGroupPresenter(activity, useCase, interactorInvoker)

    @FragmentScope @Provides
    fun provideUseCase(gateway: GymGateway) = ViewMuscleGroup(gateway)
}
