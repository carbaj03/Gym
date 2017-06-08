package com.acv.gym.di.component

import com.acv.gym.di.module.SessionSetFragmentModule
import com.acv.gym.di.scope.ActivityScope
import com.acv.gym.module.session.set.SessionSetFragment
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SessionSetFragmentModule::class))
interface SessionSetFragmentComponent {
    fun inject(fragment: SessionSetFragment)

    val presenter: SessionSetPresenter
}
