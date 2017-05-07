package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.local.ExercisesLocalGateway
import com.acv.gym.data.local.datasource.ExerciseTypeLocalDataSource
import com.acv.gym.data.local.datasource.ExercisesLocalDataSource
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.gateway.ExercisesGateway
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.exercise.GetExercisesUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import dagger.Module
import dagger.Provides

@Module
class ExerciseModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView() = activity as ExerciseView

    @ActivityScope
    @Provides
    fun providePresenter(view: ExerciseView,
                         getExerciseUseCase: GetExercisesUseCase,
                         interactorInvoker: InteractorInvoker)
            = ExercisePresenter(view, getExerciseUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(localGateway: ExercisesLocalGateway)
            = GetExercisesUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: ExercisesLocalDataSource)
            = ExercisesLocalGateway(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource() = ExercisesLocalDataSource()

    @ActivityScope @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
