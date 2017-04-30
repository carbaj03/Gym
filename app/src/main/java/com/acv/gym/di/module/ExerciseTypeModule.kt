package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.domain.gateway.DataSource
import com.acv.gym.data.local.ExerciseTypeLocalGateway
import com.acv.gym.data.model.ExerciseTypeDataModel
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import dagger.Module
import dagger.Provides

@Module
class ExerciseTypeModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): ExerciseTypeView = activity as ExerciseTypeView

    @ActivityScope
    @Provides
    fun providePresenter(view: ExerciseTypeView,
                         useCase
                         interactorInvoker: InteractorInvoker)
            = ExerciseTypePresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: ExerciseTypeLocalGateway)
            = GetExerciseTypesUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: DataSource<ExerciseTypeDataModel>)
            = ExerciseTypeLocalGateway(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource(): RoutineDataSource = RoutineDataSourceImpl()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
