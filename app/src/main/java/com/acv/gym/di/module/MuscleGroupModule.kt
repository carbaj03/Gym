package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.MuscleGroupDataSource
import com.acv.gym.data.local.MuscleGroupDataSourceImpl
import com.acv.gym.data.local.MuscleGroupGatewayImpl
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.muscle.group.MuscleGroupPresenter
import dagger.Module
import dagger.Provides

@Module
class MuscleGroupModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun providePresenter(activity: MuscleGroupActivity,
                         useCase: GetMuscleGroupsUseCase,
                         interactorInvoker: InteractorInvoker)
            = MuscleGroupPresenter(activity, useCase, interactorInvoker)

    @ActivityScope @Provides
    fun provideUseCase(localGateway: MuscleGroupLocalGateway) : GetMuscleGroupsUseCase = GetMuscleGroupsUseCase(localGateway)

    @ActivityScope @Provides
    fun provideLocalGateway(dataSource: MuscleGroupDataSource) : MuscleGroupLocalGateway  = MuscleGroupGatewayImpl(dataSource)

    @ActivityScope @Provides
    fun provideDataSource() : MuscleGroupDataSource = MuscleGroupDataSourceImpl()

    @ActivityScope @Provides
    fun provideInteractorInvoker() : InteractorInvoker = InteractorInvokerImp()

}
