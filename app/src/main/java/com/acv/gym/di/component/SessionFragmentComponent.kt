package com.acv.gym.di.component

import com.acv.gym.di.module.SessionFragmentModule
import com.acv.gym.di.scope.FragmentScope
import com.acv.gym.module.session.SessionFragment
import com.acv.gym.presentation.module.session.SessionPresenter
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = arrayOf(SessionFragmentModule::class))
interface SessionFragmentComponent {
    fun inject(fragment: SessionFragment)
    val presenter: SessionPresenter
}
