package com.acv.gym.di.component

import com.acv.gym.di.module.SessionModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.session.SessionPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SessionModule::class))
interface SessionComponent {
    fun inject(activity: SessionActivity)

    val presenter: SessionPresenter
}
