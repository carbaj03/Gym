package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.domain.usecase.session.NewSessionExerciseUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.session.NewSessionPresenter
import com.acv.gym.presentation.module.session.NewSessionView
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import dagger.Module
import dagger.Provides

@Module
class NewSessionModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): NewSessionView = activity as NewSessionView

    @ActivityScope
    @Provides
    fun providePresenter(
            view: NewSessionView,
            useCase: NewSessionExerciseUseCase,
            interactorInvoker: InteractorInvoker
    ) = NewSessionPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = NewSessionExerciseUseCase(gateway)
}
