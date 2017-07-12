package com.acv.gym.di.module


import android.support.v4.app.Fragment
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.session.ViewSet
import com.acv.gym.presentation.invoker.UseCaseInvoker
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import dagger.Module
import dagger.Provides

@Module
class SessionSetFragmentModule(fragment: Fragment) : FragmentModule(fragment) {

    @ActivityScope @Provides
    fun provideView(): SessionSetView = fragment as SessionSetView

    @ActivityScope
    @Provides
    fun providePresenter(
            view: SessionSetView,
            useCase: ViewSet,
            interactorInvoker: UseCaseInvoker
    ) = SessionSetPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = ViewSet(gateway)
}
