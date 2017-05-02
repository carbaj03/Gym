package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.local.ExerciseTypeLocalGateway
import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
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
                         getExerciseTypesUseCase: GetExerciseTypesUseCase,
                         interactorInvoker: InteractorInvoker)
            = ExerciseTypePresenter(view, getExerciseTypesUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: ExerciseTypeLocalGateway)
            = GetExerciseTypesUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: ExerciseTypeLocalDataSource)
            = ExerciseTypeLocalGateway(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource() = ExerciseTypeLocalDataSource()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
