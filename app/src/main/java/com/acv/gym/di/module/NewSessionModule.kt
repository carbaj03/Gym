package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.session.AddSessionExercise
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.module.session.create.NewSessionPresenter
import com.acv.gym.presentation.module.session.create.NewSessionView
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
            useCase: AddSessionExercise,
            interactorInvoker: UseCaseInvoker
    ) = NewSessionPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = AddSessionExercise(gateway)
}
