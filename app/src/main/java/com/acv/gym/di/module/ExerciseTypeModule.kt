package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.invoker.UseCaseInvoker
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
                         interactorInvoker: UseCaseInvoker)
            = ExerciseTypePresenter(view, getExerciseTypesUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = GetExerciseTypesUseCase(gateway)
}
