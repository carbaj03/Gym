package com.acv.gym.di.component

import com.acv.gym.di.module.SessionSetModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SessionSetModule::class))
interface SessionSetComponent {
    fun inject(activity: SessionSetActivity)

    val presenter: SessionSetPresenter
}
