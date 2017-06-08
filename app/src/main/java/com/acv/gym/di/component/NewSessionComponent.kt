package com.acv.gym.di.component

import com.acv.gym.di.module.NewSessionModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.session.NewSessionActivity
import com.acv.gym.presentation.module.session.create.NewSessionPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(NewSessionModule::class))
interface NewSessionComponent {
    fun inject(activity: NewSessionActivity)

    val presenter: NewSessionPresenter
}
