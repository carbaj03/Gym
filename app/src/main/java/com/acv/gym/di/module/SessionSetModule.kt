package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.domain.usecase.session.GetSessionSetUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import dagger.Module
import dagger.Provides

@Module
class SessionSetModule(activity: Activity) : ActivityModule(activity) {

    @ActivityScope @Provides
    fun provideView(): SessionSetView = activity as SessionSetView

    @ActivityScope
    @Provides
    fun providePresenter(
            view: SessionSetView,
            useCase: GetSessionSetUseCase,
            interactorInvoker: InteractorInvoker
    ) = SessionSetPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = GetSessionSetUseCase(gateway)
}
