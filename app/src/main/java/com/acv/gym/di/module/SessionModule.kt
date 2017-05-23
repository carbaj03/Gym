package com.acv.gym.di.module


import android.app.Activity
import com.acv.gym.data.SessionGateway
import com.acv.gym.data.db.room.datasource.SessionExerciseDataSource
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.domain.SessionGateway
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
    fun provideUseCase(localGateway: com.acv.gym.domain.SessionGateway)
            = GetSessionExercisesUseCase(localGateway)

    @ActivityScope
    @Provides
    fun provideLocalGateway(dataSource: SessionExerciseDataSource): com.acv.gym.domain.SessionGateway
            = com.acv.gym.data.SessionGateway(dataSource)

    @ActivityScope
    @Provides
    fun provideDataSource(): SessionExerciseDataSource = SessionExerciseDataSource()

    @ActivityScope
    @Provides
    fun provideInteractorInvoker(): InteractorInvoker = InteractorInvokerImp()

}
