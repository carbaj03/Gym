package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.DataSource
import com.acv.gym.data.local.MuscleGroupLocalGatewayImpl
import com.acv.gym.data.local.datasource.MuscleGroupLocalDataSource
import com.acv.gym.data.model.MuscleGroupDataModel
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.MuscleGroupLocalGateway
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.muscle.group.GetMuscleGroupsUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
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
                         useCase: GetMuscleGroupsUseCase,
                         interactorInvoker: InteractorInvoker)
            = MuscleGroupPresenter(activity, useCase, interactorInvoker)

    @ActivityScope @Provides
    fun provideUseCase(localGateway: MuscleGroupLocalGateway): GetMuscleGroupsUseCase = GetMuscleGroupsUseCase(localGateway)

    @ActivityScope @Provides
    fun provideLocalGateway(dataSource: MuscleGroupLocalDataSource) = MuscleGroupLocalGatewayImpl(dataSource)

    @ActivityScope @Provides
    fun provideDataSource(): DataSource<MuscleGroupDataModel> = MuscleGroupLocalDataSource()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
