package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.usecase.session.GetSessionExercisesUseCase
import com.acv.gym.presentation.invoker.InteractorInvoker
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import dagger.Module
import dagger.Provides

@Module class SessionFragmentModule(fragment: Fragment) : FragmentModule(fragment) {

    @FragmentScope @Provides
    fun provideView(): SessionView = fragment as SessionView

    @FragmentScope @Provides
    fun providePresenter(
            view: SessionView,
            useCase: GetSessionExercisesUseCase,
            interactorInvoker: InteractorInvoker
    ) = SessionPresenter(view, useCase, interactorInvoker)

    @FragmentScope @Provides
    fun provideUseCase(gateway: GymGateway) = GetSessionExercisesUseCase(gateway)
}
