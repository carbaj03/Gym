package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.session.ViewSessionExercise
import com.acv.gym.presentation.invoker.UseCaseInvoker
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
            useCase: ViewSessionExercise,
            interactorInvoker: UseCaseInvoker
    ) = SessionPresenter(view, useCase, interactorInvoker)

    @FragmentScope @Provides
    fun provideUseCase(gateway: GymGateway) = ViewSessionExercise(gateway)
}
