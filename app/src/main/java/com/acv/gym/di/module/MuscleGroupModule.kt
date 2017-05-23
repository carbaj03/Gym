package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.MuscleGroupGateway
import com.acv.gym.data.db.cache.datasource.MuscleGroupLocalDataSource
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.MuscleGroupGateway
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
    fun provideUseCase(localGateway: com.acv.gym.domain.MuscleGroupGateway): GetMuscleGroupsUseCase =
            GetMuscleGroupsUseCase(localGateway)

    @ActivityScope @Provides
    fun provideLocalGateway(dataSource: MuscleGroupLocalDataSource): com.acv.gym.domain.MuscleGroupGateway =
            com.acv.gym.data.MuscleGroupGateway(dataSource)

    @ActivityScope @Provides
    fun provideDataSource() = MuscleGroupLocalDataSource()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
