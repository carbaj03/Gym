package com.acv.gym.module.session


import com.acv.gym.GymApplication
import com.acv.gym.di.component.AppComponent
import com.acv.gym.di.module.AppModule
import it.cosenonjaviste.daggermock.DaggerMockRule

class EspressoDaggerMockRule(app: GymApplication) : DaggerMockRule<AppComponent>(AppComponent::class.java, AppModule(app)) {
    init {

        set { component -> GymApplication.appComponent = component }
    }

}
