package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.exercise.ViewAllExercise
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.module.exercise.ExercisePresenter
import com.acv.gym.presentation.module.exercise.ExerciseView
import dagger.Module
import dagger.Provides

@Module
class ExerciseFragmentModule(fragment: Fragment) : FragmentModule(fragment) {

    @FragmentScope @Provides
    fun provideView() = fragment as ExerciseView

    @FragmentScope @Provides
    fun providePresenter(
            view: ExerciseView,
            getExerciseUseCase: ViewAllExercise,
            interactorInvoker: UseCaseInvoker
    ) = ExercisePresenter(view, getExerciseUseCase, interactorInvoker)

    @FragmentScope @Provides
    fun provideUseCase(gateway: GymGateway): ViewAllExercise = ViewAllExercise(gateway)
}
