package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
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
    fun providePresenter(
            view: ExerciseView,
            getExerciseUseCase: GetExercisesUseCase,
            interactorInvoker: InteractorInvoker
    ) = ExercisePresenter(view, getExerciseUseCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway): GetExercisesUseCase = GetExercisesUseCase(gateway)
}
