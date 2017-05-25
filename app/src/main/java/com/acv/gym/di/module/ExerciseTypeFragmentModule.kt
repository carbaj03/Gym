package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.exercise.type.GetExerciseTypesUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import dagger.Module
import dagger.Provides

@Module
class ExerciseTypeFragmentModule(fragment: Fragment) : FragmentModule(fragment) {

    @FragmentScope @Provides
    fun provideView(): ExerciseTypeView = fragment as ExerciseTypeView

    @FragmentScope
    @Provides
    fun providePresenter(
            view: ExerciseTypeView,
            getExerciseTypesUseCase: GetExerciseTypesUseCase,
            interactorInvoker: InteractorInvoker
    ) = ExerciseTypePresenter(view, getExerciseTypesUseCase, interactorInvoker)

    @FragmentScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = GetExerciseTypesUseCase(gateway)
}
