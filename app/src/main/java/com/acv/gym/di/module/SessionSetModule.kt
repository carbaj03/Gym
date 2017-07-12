package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.service.session.ViewSet
import com.acv.gym.presentation.invoker.ServiceInvoker
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
            useCase: ViewSet,
            interactorInvoker: ServiceInvoker
    ) = SessionSetPresenter(view, useCase, interactorInvoker)

    @ActivityScope
    @Provides
    fun provideUseCase(gateway: GymGateway) = ViewSet(gateway)
}
