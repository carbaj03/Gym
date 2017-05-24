package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.invoker.InteractorInvokerImp
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import dagger.Module
import dagger.Provides

@Module
class SessionModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): SessionView = activity as SessionView

    @ActivityScope
    @Provides
    fun providePresenter(
            view: SessionView,
            useCase: GetSessionExercisesUseCase,
            interactorInvoker: InteractorInvoker
    ) = SessionPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = GetSessionExercisesUseCase(gateway)

    @ActivityScope
    @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
